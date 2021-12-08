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
            System.out.println("\nKiválasztott elem: " + nNode.getNodeName());

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
             
             
                System.out.println("Lakás azonosito: " + lakas_ID);
                System.out.println("Kapukód: " + kapukod);
                System.out.println("Irányitószám: " + ir_szam);
                System.out.println("Település: " + telepules); 
                System.out.println("Utca és Házszám: " + hazszam);
                System.out.println("Ágynemû: " + agynemu);
                
            }
        }

        nList = doc.getElementsByTagName("takaritas");
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nKiválasztott elem: " + nNode.getNodeName());

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
            System.out.println("\nKiválasztott elem: " + nNode.getNodeName());

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
            System.out.println("\nKiválasztott elem: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String vendeg_ID = elem.getAttribute("vendeg_ID");

                Node n1 = elem.getElementsByTagName("nev").item(0);
                String nev = n1.getTextContent();
                
                Node n2 = elem.getElementsByTagName("telefonszam").item(0);
                String telefonszam = n2.getTextContent();
                
                Node n3 = elem.getElementsByTagName("utlevel_sz").item(0);
                String utlevel_sz = n3.getTextContent();

                System.out.println("Vendég azonositó: " + vendeg_ID);
                System.out.println("Vendég neve: " + nev);
                System.out.println("Telefonszám: " + telefonszam);
                System.out.println("Útlevélszám: " + utlevel_sz);
                
            }
        }
        
        nList = doc.getElementsByTagName("foglalas");
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            System.out.println("\nKiválasztott elem: " + nNode.getNodeName());

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

                System.out.println("Foglalás azonositó: " + foglalas_ID);
                System.out.println("Lakás azonositó: " + lakas_IDREF);
                System.out.println("Takaritó azonositó: " + takarito_IDREF);
                System.out.println("Kezdõ dátum: " + k_datum);
                System.out.println("Záró dátum: " + z_datum);
                System.out.println("Létszám: " + fo);
                System.out.println("Vendég azonositó: " + vendeg_IDREF);
            }
        }      
    }
}