package com.me.encryptorapp;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXmlDom {

	public void read(String path){
		try{
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
	
		NodeList nList = doc.getElementsByTagName("ProcessSettings");
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
		
			Element eElement = (Element) nNode;

			//System.out.println("Staff id : " + eElement.getAttribute("Algorithm"));
			System.out.println("First Name : " + eElement.getElementsByTagName("Algorithm").item(0).getTextContent());
		
		
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		    }
	}
}
