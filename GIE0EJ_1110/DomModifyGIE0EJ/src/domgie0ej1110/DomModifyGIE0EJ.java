package domgie0ej1110;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DomModifyGIE0EJ {

	public static void main(String argv[]) {

	      try {
	         File inputFile = new File("nyelvekGIE0EJ.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node nyelvek = doc.getFirstChild();
	         Node nyelv = doc.getElementsByTagName("szerver_nyelvek").item(0);
	         
	         NamedNodeMap attr = nyelv.getAttributes();
	         Node nodeAttr = attr.getNamedItem("ceg");
	         nodeAttr.setTextContent("Oracle");

	        
	         NodeList list = nyelv.getChildNodes();
	         
	         for (int temp = 0; temp < list.getLength(); temp++) {
	            Node node = list.item(temp);
	            if (node.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) node;
	               if ("nyelv_neve".equals(eElement.getNodeName())) {
	            	   
	            	   if("Oracle 01".equals(eElement.getTextContent()))
		                     eElement.setTextContent("OOP");
	                  
	                  if("Oracle 02".equals(eElement.getTextContent()))
	                     eElement.setTextContent("Document-oriented DB");
	                  
	               	}
	               }
	            }
	         
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         System.out.println("-Modositott-");
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	}