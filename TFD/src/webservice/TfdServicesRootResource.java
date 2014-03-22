package txn.frauddetection.webservice;   
/**  * @author Israr khan 
*/  
    
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import txn.frauddetection.dao.AccountDetailsDAO;
import txn.frauddetection.data.AccountDetails;
import txn.frauddetection.data.TransactionDetails;

@Path("/")
public class TfdServicesRootResource {

	 @GET  
     @Path("getAccount/{i}")
     @Produces(MediaType.TEXT_XML)
     public AccountDetails getAccountDetails(@PathParam("i") int account) {
		System.out.print("--> Get account details -->");
    	AccountDetailsDAO accountInfo = new AccountDetailsDAO();
    	
    	return accountInfo.getAccountDetails(account);
      }   

	  @GET
      @Path("/updateAccount/{i}")
      @Produces(MediaType.TEXT_XML)
      public String updateAccountDetails(@PathParam("i") int i) {
    	     	  
          return "This Service is under construction";
      }   
      
      @POST
	  @Path("/loadTransactions")
      @Consumes(MediaType.APPLICATION_XML)
      @Produces(MediaType.TEXT_PLAIN)
	  public String loadTransactions(TransactionDetails txnDetails) {
    	  System.out.print("--> Load Transaction data -->");
	    	return "Transaction data for TransactionNumber: "+txnDetails.getTransactionNum()+" is successfully received.";
      }   
}