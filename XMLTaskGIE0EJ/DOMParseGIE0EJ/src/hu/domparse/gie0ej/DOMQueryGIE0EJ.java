package hu.domparse.gie0ej;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMQueryGIE0EJ {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ParseException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        
        File xmlFile = new File("src/XMLGIE0EJ.xml");
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        System.out.println("\nDupla ágynemûvel rendelkezõ lakás adatai:");
        
        NodeList lakaslist = doc.getElementsByTagName("lakas");

        for (int i = 0; i < lakaslist.getLength(); i++) {

            Node nNode = lakaslist.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String lakas_ID = elem.getAttribute("lakas_ID");

                Node n1 = elem.getElementsByTagName("kapukod").item(0);
                String kapukod = n1.getTextContent();

                Node n2 = elem.getElementsByTagName("ir_szam").item(0);
                String ir_szam = n2.getTextContent();
                
                Node n3 = elem.getElementsByTagName("telepules").item(0);
                String telepules = n3.getTextContent();
                
                Node n4 = elem.getElementsByTagName("utca_hazszam").item(0);
                String utca_hazszam = n4.getTextContent();
                
                Node n5 = elem.getElementsByTagName("agynemu").item(0);
                String agynemu = n5.getTextContent();
                
                if(agynemu.equals("dupla")) {
		        	 
	            	 System.out.println("Lakás azonositója: " + lakas_ID);
	            	 System.out.println("Kapukód: " + kapukod);
	                 System.out.println("Irányitószám: " + ir_szam);
	                 System.out.println("Település: " + telepules); 
	                 System.out.println("Utca és Házszám: " + utca_hazszam);
	                 System.out.println("Ágynemû: " + agynemu);
		         }
        	}   
        }
        
        System.out.println("\n2021-12-04-én kiirt takaritást végzõ dolgozó adatai és a kitakaritandó lakás települését");
        
        NodeList takaritolist = doc.getElementsByTagName("takarito");
        NodeList takaritaslist = doc.getElementsByTagName("takaritas");
        
        for (int i = 0; i < takaritolist.getLength(); i++) {

            Node nNode = takaritolist.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String takarito_ID = elem.getAttribute("takarito_ID");

                
                Node n1 = elem.getElementsByTagName("nev").item(0);
                String nev = n1.getTextContent();
                
                Node n2 = elem.getElementsByTagName("szem_ig_szam").item(0);
                String szem_ig_szam = n2.getTextContent();
                
                Node n3 = elem.getElementsByTagName("mobilszam").item(0);
                String mobilszam = n3.getTextContent();
         
		         for (int j = 0; j < takaritaslist.getLength(); j++) {
		
		             Node nNode2 = takaritaslist.item(j);
		
		             if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
		                 Element elem2 = (Element) nNode2;
		                 
		                 String lakas_IDREF = elem2.getAttribute("lakas_IDREF");
		                 String takarito_IDREF = elem2.getAttribute("takarito_IDREF");

		                 Node n4 = elem2.getElementsByTagName("idopont").item(0);
		                 String idopont = n4.getTextContent();
		  
			             if(takarito_IDREF.equals(takarito_ID) &&  idopont.equals("2021-12-04")) {
				        	 
			            	 for (int k = 0; k < lakaslist.getLength(); k++) {
			            			
					             Node nNode3 = lakaslist.item(k);
					
					             if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
					                 Element elem3 = (Element) nNode3;
					                 
					                 String lakas_ID = elem3.getAttribute("lakas_ID");

					                 Node n5 = elem3.getElementsByTagName("telepules").item(0);
					                 String telepules = n5.getTextContent();
					  
						             if(lakas_ID.equals(lakas_IDREF) ) {
							        	 
						            	 System.out.println("Takaritó azonositó: " + takarito_ID);
						                 System.out.println("Takaritó neve: " + nev);
						                 System.out.println("Személyigazolvány szám: " + szem_ig_szam);
						                 System.out.println("Mobilszám: " + mobilszam);
						                 System.out.println("Település: " + telepules); 
							         }
					             
					             }
					         }
				         }
		             }
		         }
        	}   
        }
    }
}