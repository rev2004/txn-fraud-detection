package txn.frauddetection.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Author: Israr khan
 * */

@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseXML {
	
	@XmlElement
	String ResponseCode;
	@XmlElement
	String Discription;
	
	public String getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
}
