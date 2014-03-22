package txn.frauddetection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import txn.frauddetection.data.AccountDetails;
 

public class AccountDetailsRowMapper implements RowMapper<Object>{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccountDetails account = new AccountDetails();
		account.setAccountNumber(rs.getInt("AccountNum"));
		account.setCustomerId(rs.getInt("CustomerId"));
		account.setCreditLine(rs.getInt("CreditLine"));
		return account;
	}
}
