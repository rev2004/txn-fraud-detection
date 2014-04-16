package txn.frauddetection.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import txn.frauddetection.connect.DBConnection;
import txn.frauddetection.data.ShoppingProfile;

/**
 * 
 * Author: Israr Khan
 * */

public class CustomerShoppingProfileDAO {
	JdbcTemplate jdbcTemplate;
	ShoppingProfile profile;	
	int errorId = 0;
	
	public CustomerShoppingProfileDAO(){
		DBConnection connect = new DBConnection();
		jdbcTemplate = connect.connectToDB();
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public ShoppingProfile getCustomerShoppingProfile(final Long TransactionNumber){
		profile = new ShoppingProfile();
		
		@SuppressWarnings({ "unchecked" })
		ShoppingProfile result = (ShoppingProfile) jdbcTemplate.execute( 
			     new CallableStatementCreator() { 
			        public CallableStatement createCallableStatement(Connection con) throws SQLException { 
			           String storedProc = "{call dbo.PRC_GET_Cust_ShoppingProfile(?,?,?,?,?,?)}";
			           CallableStatement cs = con.prepareCall(storedProc); 
			           cs.setLong("TransNum", TransactionNumber);
			           
			           cs.registerOutParameter("MinTransAmt", Types.DECIMAL);
			           cs.registerOutParameter("MaxTransAmt", Types.DECIMAL);
			           cs.registerOutParameter("NumTransPerHr", Types.INTEGER);
			           cs.registerOutParameter("ShoppingRadius", Types.INTEGER);
			           cs.registerOutParameter("ErrorID", Types.INTEGER);
			           return cs; 
			        } 
			     }, new CallableStatementCallback() { 
			        public Object doInCallableStatement(CallableStatement cs) throws SQLException,DataAccessException { 
			           cs.execute();
			           profile.setMinTransAmount(cs.getDouble("MinTransAmt"));
			           profile.setMaxTransAmount(cs.getDouble("MaxTransAmt"));
			           profile.setNumTransPerHr(cs.getInt("NumTransPerHr"));
			           profile.setShoppingRadius(cs.getInt("ShoppingRadius"));
			           errorId = cs.getInt("ErrorID");
			           return profile;
		           } 
			  }); 

		if(errorId == 0)
			return profile;
		else{
			System.out.println("Error occured at the db level, ErrorId: "+errorId);
			return new ShoppingProfile();
		}
	}
}
