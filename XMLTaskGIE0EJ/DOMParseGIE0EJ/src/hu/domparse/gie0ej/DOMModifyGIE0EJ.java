package hu.domparse.gie0ej;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.transform.OutputKeys;

import javax.xml.transform.TransformerException;

public class DOMModifyGIE0EJ {

    public static void main(String[] args) {

    	try {
            File inputFile = new File("src/XMLGIE0EJ.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
           

          // Nagy Katalin telefonszolgáltatót váltott és új lett a mobilszáma
            NodeList takaritoList = doc.getElementsByTagName("takarito");
            for (int i = 0; i < takaritoList.getLength(); i++) {

                Node nNode1 = takaritoList.item(i);

                if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nNode1;

                    Node n1 = elem.getElementsByTagName("nev").item(0);
                    String nev = n1.getTextContent();

                    if (nev.equals("Nagy Katalin")) {
                    	
                    	NodeList childNodes = nNode1.getChildNodes();
						for (int j = 0; j < childNodes.getLength(); j++) {
							Node childNode = childNodes.item(j);
							if (childNode.getNodeName().equals("mobilszam")) {
								childNode.setTextContent("06304433245");
								
								 
							}

						}
                       
                    }
                }
            }
            
            modify(doc);
            
    	} catch (Exception e) {
			e.printStackTrace();
		}
            
            
    }
    
    private static void modify(Document doc) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		System.out.println("-Modified File-");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amunt", "2");

		DOMSource source = new DOMSource(doc);

		StreamResult console = new StreamResult(System.out);

		transformer.transform(source, console);
		
	}
}