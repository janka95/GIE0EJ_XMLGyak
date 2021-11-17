package xpathgie0ej1110;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class xPathGIE0EJ {
	
	public static void main(String[] args) {
		
		try {
		
		File xmlFile = new File("studentGIE0EJ.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document document = documentBuilder.parse("studentGIE0EJ.xml");
		
		document.getDocumentElement().normalize();
		
		XPath xPath = XPathFactory.newInstance().newXPath();
		
		String expression = "class";
		
		//student id=1
		//String expression = "class/student[@id=01]";
				
		//összes student
		//String expression = "class/student";
				
		//2. student
		//String expression = "class/student[position()=2]";
				
		//utolsó student
		//String expression = "class/student[last()]";
				
		//uelõtti student
		//String expression = "class/student[last()-1]";
				
		//elsõ 2 student
		//String expression = "class/student[position()<3]";
				
		//minden gyerek
		//String expression = "//*";
				
		//legalább 1 tulajdonság
		//String expression = "class/student[@*]";
				
		//20 év felettiek
		//String expression = "class/student[kor>20]";
		
		
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			
			Node node = nodeList.item(i);
			
			System.out.println("\nAktuÃ¡lis elem: " + node.getNodeName());
			
			if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
				Element element = (Element) node;
				
				System.out.println("HallgatÃ³ ID: "
						+ element.getAttribute("id"));
				
				System.out.println("KeresztnÃ©v: "
						+ element.getElementsByTagName("keresztnev").item(0).getTextContent());
				
				System.out.println("VezetÃ©knÃ©v: "
						+ element.getElementsByTagName("vezeteknev").item(0).getTextContent());
			
				System.out.println("BecenÃ©v: "
						+ element.getElementsByTagName("becenev").item(0).getTextContent());	
						
				System.out.println("Kor: "
								+ element.getElementsByTagName("kor").item(0).getTextContent());					
		 }
			
		}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			
		}
	}
}
