package txn.frauddetection.data;

import java.net.*;
import java.io.*;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;


public class DistanceCalculator {

//	public main(String[] args) 
//	{
//		String FrmAdd = "401 City Ave, Bala Cynwyd, PA 19004";
//		String ToAdd = "30 E Swedesford Rd, Malvern, PA 19355";
//		
//		double distance = GetDistanceInMiles(FrmAdd,ToAdd);
//		
//		System.out.println("From Address: " + FrmAdd);
//		System.out.println("To Address: " + ToAdd);
//		System.out.println("Distance Between them is " + distance +" miles");
//	}

	public double GetDistanceInMiles(String FromAddress, String ToAddress) 
	{
		double distance = 0;
		String orign_address  = FromAddress.replace(" ", "+");
		String destin_address = ToAddress.replace(" ", "+");
		try 
		{
		  URL gmatrix = new URL("http://maps.googleapis.com/maps/api/distancematrix/xml?origins=\""+orign_address+"\"&destinations=\""+destin_address+"\"&mode=driving&units=imperial&sensor=false");
		  String xmlstring;
		  BufferedReader in = new BufferedReader(
		  new InputStreamReader(gmatrix.openStream()));

		  String inputLine;
		  xmlstring = "";
		  //Read the xml payload returned from the URL 
		  while ((inputLine = in.readLine()) != null)
		      xmlstring = xmlstring+inputLine;
		  in.close();
          
		  //System.out.println("XML Payload :");
		  //System.out.println("xmlstring");
		  
		  // Convert the String to XML DOM
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = dbf.newDocumentBuilder();
	      Document xmldoc = db.parse(new InputSource(new StringReader(xmlstring)));
	      
	      //--------- Fetch the Distance from the xml  ---
	      String expression = "/DistanceMatrixResponse/row/element/distance/text";
	      XPath xPath =  XPathFactory.newInstance().newXPath();
	        
	      String dist = xPath.compile(expression).evaluate(xmldoc); 
	      
		  //System.out.println("The Distance is "+dist.replace("mi", " ").trim());
	      
	      distance = Double.parseDouble(dist.replace("mi", " ").trim());
		  return distance;

		}
		
		catch (Exception ex)
		{
			System.out.println("Error in getting the Distance "+ ex.getMessage());
			//throw ex;
			return -1;
		}
		
	}
}