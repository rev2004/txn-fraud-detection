package txn.frauddetection.data;
/*
 * Author: Israr khan
 * */
import java.sql.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TransactionDetails")
public class TransactionDetails {
	
	@XmlElement(required=true)
	private int TransactionNum;
	@XmlElement(required=true)
	private int CreditCardNum;
	@XmlElement(required=true)
	private String TransactionDate;
	@XmlElement(required=true)
	private double Amount;
	@XmlElement
	private String Description;
	@XmlElement(required=true)
	private String MerchantName;
	@XmlElement(required=true)
	private String MerchantAddress;
	@XmlElement(required=true)
	private String MerchantCity;
	@XmlElement(required=true)
	private String MerchantState;
	@XmlElement
	private int MerchantZipCode;
	@XmlElement(required=true)
	private String MerchantCountry;
	@XmlElement
	private String MerchantPhone;

	public TransactionDetails(){
		
	}
	
	public TransactionDetails(Builder builder){
		this.TransactionNum = builder.TransactionNum;
		this.CreditCardNum = builder.CreditCardNum;
		this.Amount = builder.Amount;
		this.TransactionDate = builder.TransactionDate;
		this.Description = builder.Description;
		this.MerchantAddress = builder.MerchantAddress;
		this.MerchantName = builder.MerchantName;
		this.MerchantCity = builder.MerchantCity;
		this.MerchantState = builder.MerchantState;
		this.MerchantCountry = builder.MerchantCountry;
		this.MerchantPhone = builder.MerchantPhone;
	}
	
	public int getTransactionNum() {
		return TransactionNum;
	}

	
	public void setTransactionNum(int transactionNum) {
		TransactionNum = transactionNum;
	}
	public int getCreditCardNum() {
		return CreditCardNum;
	}
	
	
	public void setCreditCardNum(int creditCardNum) {
		CreditCardNum = creditCardNum;
	}
	public String getTransactionDate() {
		return TransactionDate;
	}
	
	
	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}
	public double getAmount() {
		return Amount;
	}
	
	
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getDescription() {
		return Description;
	}
	
	
	public void setDescription(String description) {
		Description = description;
	}
	public String getMerchantName() {
		return MerchantName;
	}
	
	
	public void setMerchantName(String merchantName) {
		MerchantName = merchantName;
	}
	public String getMerchantAddress() {
		return MerchantAddress;
	}
	
	
	public void setMerchantAddress(String merchantAddress) {
		MerchantAddress = merchantAddress;
	}
	public String getMerchantCity() {
		return MerchantCity;
	}
	
	
	public void setMerchantCity(String merchantCity) {
		MerchantCity = merchantCity;
	}
	public String getMerchantState() {
		return MerchantState;
	}
	
	
	public void setMerchantState(String merchantState) {
		MerchantState = merchantState;
	}
	public int getMerchantZipCode() {
		return MerchantZipCode;
	}
	
	
	public void setMerchantZipCode(int merchantZipCode) {
		MerchantZipCode = merchantZipCode;
	}
	public String getMerchantCountry() {
		return MerchantCountry;
	}
	
	
	public void setMerchantCountry(String merchantCountry) {
		MerchantCountry = merchantCountry;
	}
	public String getMerchantPhone() {
		return MerchantPhone;
	}
	
	
	public void setMerchantPhone(String merchantPhone) {
		MerchantPhone = merchantPhone;
	}
	
	public static class Builder{
		
		private int TransactionNum;
		private int CreditCardNum;
		private String TransactionDate;
		private double Amount;
		private String Description;
		private String MerchantName;
		private String MerchantAddress;
		private String MerchantCity;
		private String MerchantState;
		private int MerchantZipCode;
		private String MerchantCountry;
		private String MerchantPhone;
		
		public  static Builder TransactionNum(int val){
			Builder builder= new Builder();
			builder.TransactionNum = val;
			return builder;
		}
		
		public Builder CreditCardNum(int val){
			this.CreditCardNum = val;
			return this;
		}
		
		public Builder TransactionDate(String val){
			this.TransactionDate = val;
			return this;
		}
		
		public Builder Amount(double val){
			this.Amount = val;
			return this;
		}
		
		public Builder Description(String val){
			this.Description = val;
			return this;
		}
		
		public Builder MerchantName(String val){
			this.MerchantName = val;
			return this;
		}
		
		public Builder MerchantAddress(String val){
			this.MerchantAddress = val;
			return this;
		}
		
		public Builder MerchantCity(String val){
			this.MerchantCity = val;
			return this;
		}
		
		public Builder MerchantState(String val){
			this.MerchantState = val;
			return this;
		}
		
		public Builder MerchantZipCode(int val){
			this.MerchantZipCode = val;
			return this;
		}
		
		public Builder MerchantCountry(String val){
			this.MerchantCountry = val;
			return this;
		}
		
		public Builder MerchantPhone(String val){
			this.MerchantPhone = val;
			return this;
		}
		
		public TransactionDetails build(){
			return new TransactionDetails(this);
		}
		
	}

}
