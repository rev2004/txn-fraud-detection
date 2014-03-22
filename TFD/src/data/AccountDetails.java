package txn.frauddetection.data;
/*
 * Author: Israr khan
 * */
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountDetails {
	
	private int AccountNumber;
	private int CustomerId;
	private double CreditLine;
	private String OpeningDate;
	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String State;
	private int zipcode;
	private String SSN;
	private String DOB;
	
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public double getCreditLine() {
		return CreditLine;
	}
	public void setCreditLine(double creditLine) {
		CreditLine = creditLine;
	}
	
	public String getOpeningDate() {
		return OpeningDate;
	}
	public void setOpeningDate(String openingDate) {
		OpeningDate = openingDate;
	}
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
}
