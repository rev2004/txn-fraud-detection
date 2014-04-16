package txn.frauddetection.data;
/**
 * Author: Israr khan
 * */

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ResponseXMLs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseXMLs {

	@XmlElement(name="Responsexml")
	List<ResponseXML> responseXml;

	
	public List<ResponseXML> getResponseXml() {
		return responseXml;
	}
	
	public void setResponseXml(List<ResponseXML> responseXml) {
		this.responseXml = responseXml;
	}
}
