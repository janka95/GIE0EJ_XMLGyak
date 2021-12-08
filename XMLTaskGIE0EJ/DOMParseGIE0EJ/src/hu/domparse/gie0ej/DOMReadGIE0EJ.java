package hu.domparse.gie0ej;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class DOMReadGIE0EJ {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

      
        File xmlFile = new File("src/XMLGIE0EJ.xml");
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();
        
        System.out.println("Root elem: " + doc.getDocumentElement().getNodeName());

      
        NodeList nList = doc.getElementsByTagName("lakas");
     
        for (int i = 0; i < nList.getLength(); i++) {

          
            Node nNode = nList.item(i);
            System.out.println("\nKiv�lasztott elem: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String lakas_ID = elem.getAttribute("lakas_ID");

                Node n1 = elem.getElementsByTagName("ir_szam").item(0);
                String ir_szam = n1.getTextContent();

                Node n2 = elem.getElementsByTagName("telepules").item(0);
                String telepules = n2.getTextContent();

                Node n3 = elem.getElementsByTagName("utca_hazszam").item(0);
                String hazszam = n3.getTextContent();
                
                Node n4 = elem.getElementsByTagName("agynemu").item(0);
                String agynemu = n4.getTextContent();
                
                Node n5 = elem.getElementsByTagName("kapukod").item(0);
                String kapukod = n5.getTextContent(); 
             
             
                System.out.println("Lak�s azonosito: " + lakas_ID);
                System.out.println("Kapuk�d: " + kapukod);
                System.out.println("Ir�nyit�sz�m: " + ir_szam);
                System.out.println("Telep�l�s: " + telepules); 
                System.out.println("Utca �s H�zsz�m: " + hazszam);
                System.out.println("�gynem�: " + agynemu);
                
            }
        }

        nList = doc.getElementsByTagName("takaritas");
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nKiv�lasztott elem: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String lakas_IDREF = elem.getAttribute("lakas_IDREF");
                String takarito_IDREF = elem.getAttribute("takarito_IDREF");

                Node n1 = elem.getElementsByTagName("idopont").item(0);
                String idopont = n1.getTextContent();

                System.out.println("Lakas azonosito: " + lakas_IDREF);
                System.out.println("Idopont: " + idopont);
                System.out.println("Takarito azonosito: " + takarito_IDREF);
                
            }
        }

        nList = doc.getElementsByTagName("takarito");
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nKiv�lasztott elem: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String takarito_ID = elem.getAttribute("takarito_ID");

                Node n1 = elem.getElementsByTagName("nev").item(0);
                String nev = n1.getTextContent();
                Node n2 = elem.getElementsByTagName("szem_ig_szam").item(0);
                String szem_ig_szam = n2.getTextContent();
                Node n3 = elem.getElementsByTagName("mobilszam").item(0);
                String mobilszam = n3.getTextContent();

                System.out.println("Takarito azonosito " + takarito_ID);
                System.out.println("Takarito neve: " + nev);
                System.out.println("Szemelyi igazolvany szam: " + szem_ig_szam);
                System.out.println("Mobilszam: " + mobilszam);
            }
        }
        
        nList = doc.getElementsByTagName("vendeg");
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nKiv�lasztott elem: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String vendeg_ID = elem.getAttribute("vendeg_ID");

                Node n1 = elem.getElementsByTagName("nev").item(0);
                String nev = n1.getTextContent();
                
                Node n2 = elem.getElementsByTagName("telefonszam").item(0);
                String telefonszam = n2.getTextContent();
                
                Node n3 = elem.getElementsByTagName("utlevel_sz").item(0);
                String utlevel_sz = n3.getTextContent();

                System.out.println("Vend�g azonosit�: " + vendeg_ID);
                System.out.println("Vend�g neve: " + nev);
                System.out.println("Telefonsz�m: " + telefonszam);
                System.out.println("�tlev�lsz�m: " + utlevel_sz);
                
            }
        }
        
        nList = doc.getElementsByTagName("foglalas");
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nKiv�lasztott elem: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String foglalas_ID = elem.getAttribute("foglalas_ID");
                String lakas_IDREF = elem.getAttribute("lakas_IDREF");
                String takarito_IDREF = elem.getAttribute("takarito_IDREF");
                String vendeg_IDREF = elem.getAttribute("vendeg_IDREF");
                

                Node n1 = elem.getElementsByTagName("k_datum").item(0);
                String k_datum = n1.getTextContent();

                Node n2 = elem.getElementsByTagName("z_datum").item(0);
                String z_datum = n2.getTextContent();

                Node n3 = elem.getElementsByTagName("fo").item(0);
                String fo = n3.getTextContent();

                System.out.println("Foglal�s azonosit�: " + foglalas_ID);
                System.out.println("Lak�s azonosit�: " + lakas_IDREF);
                System.out.println("Takarit� azonosit�: " + takarito_IDREF);
                System.out.println("Kezd� d�tum: " + k_datum);
                System.out.println("Z�r� d�tum: " + z_datum);
                System.out.println("L�tsz�m: " + fo);
                System.out.println("Vend�g azonosit�: " + vendeg_IDREF);
            }
        }      
    }
}