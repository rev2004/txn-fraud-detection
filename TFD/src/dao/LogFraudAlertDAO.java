package txn.frauddetection.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import txn.frauddetection.connect.DBConnection;

public class LogFraudAlertDAO {
	JdbcTemplate jdbcTemplate;
	boolean isInserted;
	
	public LogFraudAlertDAO(){
		DBConnection connect = new DBConnection();
		jdbcTemplate = connect.connectToDB();
		isInserted = false;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public boolean addFraudAlert(final Long txnNum,final int customerId, final String mailText){
				
		@SuppressWarnings("unchecked")
		List rs = (ArrayList) jdbcTemplate.execute( 
			     new CallableStatementCreator() { 
			        public CallableStatement createCallableStatement(Connection con) throws SQLException { 
			           String storedProc = "{call dbo.PRC_TFD_LogAlertLog(?,?,?)}";
			           CallableStatement cs = con.prepareCall(storedProc); 
			           cs.setLong("TransactionNum", txnNum);
			           cs.setInt("CustomerID",customerId);
			           cs.setString("MailText", mailText);
			           
			           return cs; 
			        } 
			     }, new CallableStatementCallback() { 
			        public Object doInCallableStatement(CallableStatement cs) throws SQLException,DataAccessException { 
			           List resultsMap = new ArrayList(); 
			           cs.execute();
			           if(cs.getUpdateCount() > 0){
			        	   isInserted = true;
			           }
			           return resultsMap;
		           } 
			  }); 

		return isInserted;
	}
}
