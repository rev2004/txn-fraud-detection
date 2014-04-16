package txn.frauddetection.webservice;

import txn.frauddetection.dao.AddTransactionDAO;
import txn.frauddetection.dao.CustomerAddressDAO;
import txn.frauddetection.dao.CustomerShoppingProfileDAO;
import txn.frauddetection.dao.LogFraudAlertDAO;
import txn.frauddetection.data.AccountDetails;
import txn.frauddetection.data.DistanceCalculator;
import txn.frauddetection.data.ResponseXML;
import txn.frauddetection.data.SendTextOrEmail;
import txn.frauddetection.data.ShoppingProfile;
import txn.frauddetection.data.TransactionDetails;

public class TFDService {
	int fraudScore = 0;
	
	public ResponseXML AddTransactionAndDetectFraud(TransactionDetails txnDetails){
		
		AddTransactionDAO addTxnDao = new AddTransactionDAO();
		CustomerAddressDAO customerAddressDao = new CustomerAddressDAO();
		CustomerShoppingProfileDAO profileDao = new CustomerShoppingProfileDAO();
		Long transactionNumber = addTxnDao.AddTransaction(txnDetails);
		txnDetails.setTransactionNum(transactionNumber);
		AccountDetails accountDetails = customerAddressDao.getCustomerAddress(txnDetails.getCreditCardNum());
		ShoppingProfile profile = profileDao.getCustomerShoppingProfile(transactionNumber);
		accountDetails.setShoppingProfile(profile);
		ResponseXML response = calculateDistanceAndSendMessage(accountDetails,txnDetails);
		return response;
	}
	
	private ResponseXML calculateDistanceAndSendMessage(AccountDetails accountDetails,TransactionDetails txnDetails){
		ResponseXML response = new ResponseXML();
		response.setDiscription("Credit Card Number: "+txnDetails.getCreditCardNum()+" Transaction# "+txnDetails.getTransactionRefNum());
		DistanceCalculator distanceCalculator = new DistanceCalculator();
  	  	String ToAddress = txnDetails.getMerchantAddress() +" "+txnDetails.getMerchantCity()+" "+txnDetails.getMerchantState()+" "+txnDetails.getMerchantZipCode();
  	  	String homeAddress = accountDetails.getHomeAddress() + " " + accountDetails.getHomeCity()+" "+accountDetails.getHomeState()+" "+accountDetails.getHomeZipCode();
  	  	double distanceFromHome = distanceCalculator.GetDistanceInMiles(homeAddress, ToAddress);
  	    String workAddress = accountDetails.getWorkAddress() + " " + accountDetails.getWorkCity()+" "+accountDetails.getWorkState()+" "+accountDetails.getWorkZipCode();
  	    double distanceFromWork = distanceCalculator.GetDistanceInMiles(workAddress, ToAddress);
  	  	int shoppingRadius = accountDetails.getShoppingProfile().getShoppingRadius();
  	  	response.setDiscription(response.getDiscription()+"\nDistance between Merchant address and client's home address is: "+distanceFromHome+" Miles");
  	  	response.setDiscription(response.getDiscription()+"\nDistance between Merchant address and client's work address is: "+distanceFromWork+" Miles");
  	  	response = compareDistanceToRadius(distanceFromHome,distanceFromWork,shoppingRadius,response);
	    
	    if(txnDetails.getAmount() > accountDetails.getShoppingProfile().getMaxTransAmount()){
	    	fraudScore = fraudScore + 150;
	    	response.setDiscription(response.getDiscription() + "\nTransaction amount is more than the max amount on the account, fraud detected.");
	    }
	    if(fraudScore >= 250){
	      String message = constructMessage(txnDetails);
	      LogFraudAlertDAO logAlert = new LogFraudAlertDAO();
	      boolean isInserted = logAlert.addFraudAlert(txnDetails.getTransactionNum(), accountDetails.getCustomerId(), message);
	      if(isInserted)
	    	  response = sendMessage(txnDetails,response,message,accountDetails.getCustomerId());
	      else{
	    	  response.setResponseCode("Error");
	    	  response.setDiscription(response.getDiscription()+"\n Failed to send message, internal db error");
	      }
	    }
	    return response;
	}
	
	private ResponseXML sendMessage(TransactionDetails txnDetails, ResponseXML response,String message,int customerId){
		SendTextOrEmail sendTxt = new SendTextOrEmail();
	    boolean isSent = sendTxt.SendTextOrEmailToCustomer(txnDetails,message,customerId);
	    if(isSent){
		  response.setResponseCode("Success");
		  response.setDiscription(response.getDiscription() + "\n Message sent to client.");
	    }else{
		  response.setResponseCode("Failure");
		  response.setDiscription(response.getDiscription() + "\nSending message failed.");
	    }
	    return response;
	}
	
	private ResponseXML compareDistanceToRadius(double distanceFromHome,double distanceFromWork,int shoppingRadius,ResponseXML response){
		
		 if(distanceFromHome > shoppingRadius){
			 fraudScore = fraudScore + 50;
	    	if(distanceFromWork > shoppingRadius){
	    		fraudScore = fraudScore + 100;
		      response.setResponseCode("Failure");
		      response.setDiscription(response.getDiscription() +"\nThe distance is more than "+shoppingRadius+" miles so the transaction is flaged as fraud.");
		      
	    	}else{
		      response.setResponseCode("Success");
		      response.setDiscription(response.getDiscription() + "\nThe transaction is made with in "+shoppingRadius+" miles so its not flaged as fraud.");
		    }
       }else{
    	 response.setResponseCode("Success");
    	 response.setDiscription(response.getDiscription() + "\nThe transaction is made with in "+shoppingRadius+" miles so its not flaged as fraud.");
      }
	  return response;
	}
	
	private String constructMessage(TransactionDetails txnDetails) {
		String message = "Fraud has been identified on the following transaction:\r";
		message += "\nCard Number: "+txnDetails.getCreditCardNum()+" Transaction Date: "+txnDetails.getTransactionDate()
				+" Transaction Amount: "+txnDetails.getAmount()+" Merchant Address: "+txnDetails.getMerchantAddress()+" "
				+ txnDetails.getMerchantCity()+" "+txnDetails.getMerchantState()+" "+txnDetails.getMerchantZipCode()
				+"\n\nPlease accept if you made this transaction OR deny if this is a fraudulent transaction";
		return message;
	}

}
