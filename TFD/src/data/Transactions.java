package txn.frauddetection.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Transactions")
public class Transactions {
	
	
	private List<TransactionDetails> transactionDetails;

	@XmlElement(name = "TransactionDetails")
	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
//		for(int i=0; i<= transactionDetails.size(); i++){
//			this.transactionDetails.add(transactionDetails.get(i));
//		}
	}
}
