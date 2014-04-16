/**
 * 
 * Author: Israr Khan
 * */
package txn.frauddetection.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import txn.frauddetection.connect.DBConnection;
import txn.frauddetection.data.TransactionDetails;

public class AddTransactionDAO {
	JdbcTemplate jdbcTemplate;
	Long txnNum = new Long("0");
	int errorId = 0;
	
	public AddTransactionDAO(){
		DBConnection connect = new DBConnection();
		jdbcTemplate = connect.connectToDB();
	}
	
	@SuppressWarnings("rawtypes")
	public Long AddTransaction(TransactionDetails txnDetails){
		final Long CCNumber = txnDetails.getCreditCardNum();
		final String txnRefNum  = txnDetails.getTransactionRefNum();
		final String txnDate = txnDetails.getTransactionDate();
		final double amount = txnDetails.getAmount();
		final String discription = txnDetails.getDescription();
		final String merchantName = txnDetails.getMerchantName();
		final String merchantAddress = txnDetails.getMerchantAddress();
		final String merchantCity = txnDetails.getMerchantCity();
		final String merchantState = txnDetails.getMerchantState();
		final String merchantZipCode = txnDetails.getMerchantZipCode();
		final String merchantCountry = txnDetails.getTransactionDate();
		final String merchantPhone = txnDetails.getTransactionDate();
		
		@SuppressWarnings("unchecked")
		List rs = (ArrayList) jdbcTemplate.execute( 
			     new CallableStatementCreator() { 
			        public CallableStatement createCallableStatement(Connection con) throws SQLException { 
			           String storedProc = "{call dbo.PRC_TFD_AddTransaction(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			           CallableStatement cs = con.prepareCall(storedProc); 
			           cs.setLong("CreditCardNum", CCNumber);
			           cs.setString("TransactionRefNum", txnRefNum);
			           cs.setString("TransactionDateTime", txnDate);
			           cs.setDouble("Amount", amount);
			           cs.setString("Description", discription);
			           cs.setString("MerchantName", merchantName);
			           cs.setString("MerchantAddress", merchantAddress);
			           cs.setString("MerchantCity", merchantCity);
			           cs.setString("MerchantState", merchantState);
			           cs.setString("MerchantZipCode", merchantZipCode);
			           cs.setString("MerchantCountry", merchantCountry);
			           cs.setString("MerchantPhone", merchantPhone);
			           cs.registerOutParameter("TransactionNum", Types.INTEGER);
			           cs.registerOutParameter("ErrorID", Types.INTEGER);
			           return cs; 
			        } 
			     }, new CallableStatementCallback() { 
			        public Object doInCallableStatement(CallableStatement cs) throws SQLException,DataAccessException { 
			           List resultsMap = new ArrayList(); 
			           cs.execute();
			           txnNum = cs.getLong("TransactionNum");
			           errorId = cs.getInt("ErrorID");
			           resultsMap.add(txnNum);
			           resultsMap.add(errorId);
			           return resultsMap;
		           } 
			  }); 

		if(errorId == 0)
			return txnNum;
		else{
			System.out.println("Error occured at the db level, ErrorId: "+errorId);
			return new Long(errorId);
		}
	}
}
