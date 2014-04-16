package txn.frauddetection.dao;
/**
 * 
 * Author: Israr Khan
 * */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import txn.frauddetection.connect.DBConnection;
import txn.frauddetection.data.AccountDetails;

public class CustomerAddressDAO {
	JdbcTemplate jdbcTemplate;
	AccountDetails accountDetails;	
	int errorId = 0;
	
	public CustomerAddressDAO(){
		DBConnection connect = new DBConnection();
		jdbcTemplate = connect.connectToDB();
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public AccountDetails getCustomerAddress(final Long creditCardNumber){
		accountDetails = new AccountDetails();
		
		@SuppressWarnings({ "unchecked" })
		AccountDetails result = (AccountDetails) jdbcTemplate.execute( 
			     new CallableStatementCreator() { 
			        public CallableStatement createCallableStatement(Connection con) throws SQLException { 
			           String storedProc = "{call dbo.PRC_GET_CustomerAddressUsingCreditCardNum(?,?,?,?,?,?,?,?,?,?)}";
			           CallableStatement cs = con.prepareCall(storedProc); 
			           cs.setLong("CreditCardNum", creditCardNumber);
			           
			           cs.registerOutParameter("HomeAddress", Types.VARCHAR);
			           cs.registerOutParameter("HomeCity", Types.VARCHAR);
			           cs.registerOutParameter("HomeState", Types.VARCHAR);
			           cs.registerOutParameter("HomeZipCode", Types.VARCHAR);
			           cs.registerOutParameter("WorkAddress", Types.VARCHAR);
			           cs.registerOutParameter("WorkCity", Types.VARCHAR);
			           cs.registerOutParameter("WorkState", Types.VARCHAR);
			           cs.registerOutParameter("WorkZipCode", Types.VARCHAR);
			           cs.registerOutParameter("ErrorID", Types.INTEGER);
			           return cs; 
			        } 
			     }, new CallableStatementCallback() { 
			        public Object doInCallableStatement(CallableStatement cs) throws SQLException,DataAccessException { 
			           cs.execute();
			           accountDetails.setHomeAddress(cs.getString("HomeAddress"));
			           accountDetails.setHomeCity(cs.getString("HomeCity"));
			           accountDetails.setHomeState(cs.getString("HomeState"));
			           accountDetails.setHomeZipCode(cs.getString("HomeZipCode"));
			           accountDetails.setWorkAddress(cs.getString("WorkAddress"));
			           accountDetails.setWorkCity(cs.getString("WorkCity"));
			           accountDetails.setWorkState(cs.getString("WorkState"));
			           accountDetails.setWorkZipCode(cs.getString("WorkZipCode"));
			           accountDetails.setCustomerId(111124);
			           errorId = cs.getInt("ErrorID");
			           return accountDetails;
		           } 
			  }); 

		if(errorId == 0)
			return accountDetails;
		else{
			System.out.println("Error occured at the db level, ErrorId: "+errorId);
			return new AccountDetails();
		}
	}
}
