package txn.frauddetection.dao;
/*
 * Author: Israr khan
 * */
import java.sql.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import txn.frauddetection.data.AccountDetails;

public class AccountDetailsDAO {

	String GET_ACCOUNT_DETAILS = "select * from Account where accountNumber=";
//	private DataSource dataSource;
//
//	  public void setDataSource(DataSource ds) {
//	    dataSource = ds;
//	  }


	public AccountDetails getAccountDetails(int accountNumber){
		//AccountDetails acctDetails = new AccountDetails();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
		dataSource.setUrl("jdbc:jtds:sqlserver://96.245.177.114:1443/MSSQLSERVER1");
		dataSource.setUsername("IKHAN");
		dataSource.setPassword("Password123");

		String sql = "SELECT * FROM Account";
		 
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return (AccountDetails) select.query(sql,new AccountDetailsRowMapper());

//		acctDetails.setAccountNumber(1234);
//		acctDetails.setCreditLine(100.23);
//		acctDetails.setCustomerId(1);
//		acctDetails.setOpeningDate("02-17-2014");
//		acctDetails.setFirstName("Israr");
//		acctDetails.setLastName("Khan");
//		acctDetails.setAddress("8728 Ditman st");
//		acctDetails.setCity("Philadelphia");
//		acctDetails.setZipcode(19136);
//		acctDetails.setState("PA");
//		acctDetails.setSSN("123456789");
//		acctDetails.setDOB("02-17-2014");
		//return acctDetails;
	}
}
