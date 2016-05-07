/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import java.awt.List;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author ace
 */
public class XmlImport {
    private static ArrayList contactGegevens2;
    private static ArrayList bestelling2;
    
    public static ArrayList XmlImportFromFile(String bestandslocatie){
    
    ArrayList contactGegevens = new ArrayList<String>();
    ArrayList bestelling = new ArrayList<String>();
    ArrayList list = new ArrayList<String>();
    
    try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() {

	boolean bordernummer = false;            
        boolean bvnaam = false;
	boolean banaam = false;
	boolean badres = false;
	boolean bpostcode = false;
        boolean bplaats = false;
        boolean bdatum = false;
        boolean bartikelnr = false;

	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {

		//System.out.println("Start Element :" + qName + "");
                
                if(qName.equalsIgnoreCase("ORDERNUMMER")){
                    bordernummer = true;
                }

		if (qName.equalsIgnoreCase("VOORNAAM")) {
			bvnaam = true;
		}

		if (qName.equalsIgnoreCase("ACHTERNAAM")) {
			banaam = true;
		}

		if (qName.equalsIgnoreCase("ADRES")) {
			badres = true;
		}

		if (qName.equalsIgnoreCase("POSTCODE")) {
			bpostcode = true;
		}
                
                if (qName.equalsIgnoreCase("PLAATS")) {
			bplaats = true;
		}
                
                if (qName.equalsIgnoreCase("DATUM")) {
			bdatum = true;
		}
                
                if (qName.equalsIgnoreCase("ARTIKELNR")) {
			bartikelnr = true;
		}

	}


	public void characters(char ch[], int start, int length) throws SAXException {

                if (bordernummer) {                        
			//System.out.println("Ordernummer : " + new String(ch, start, length));                        
                        bestelling.add(new String(ch, start, length));
			bordernummer = false;
		}
            
		if (bvnaam) {
			//System.out.println("Voornaam : " + new String(ch, start, length));
                        contactGegevens.add(new String(ch, start, length));
			bvnaam = false;
		}

		if (banaam) {
			//System.out.println("Achternaam : " + new String(ch, start, length));
                        contactGegevens.add(new String(ch, start, length));
			banaam = false;
		}

		if (badres) {
			//System.out.println("Adres : " + new String(ch, start, length));
                        contactGegevens.add(new String(ch, start, length));
			badres = false;
		}

		if (bpostcode) {
			//System.out.println("Postcode : " + new String(ch, start, length));
                        contactGegevens.add(new String(ch, start, length));
			bpostcode = false;
		}
                
                if (bplaats) {
			//System.out.println("Plaats : " + new String(ch, start, length));
                        contactGegevens.add(new String(ch, start, length));
			bplaats = false;
		}
                
                if (bdatum) {
			//System.out.println("Datum : " + new String(ch, start, length));
                        contactGegevens.add(new String(ch, start, length));
			bdatum = false;
		}
                
                if (bartikelnr) {
			//System.out.println("Artikelnummer : " + new String(ch, start, length));
                        bestelling.add(new String(ch, start, length));
			bartikelnr = false;
		}

	}
        
        
	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		//System.out.println("End Element :" + qName);

	}

    };

        saxParser.parse(bestandslocatie, handler);
 
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    
        contactGegevens2 = contactGegevens;
        bestelling2 = bestelling;
        list.add(contactGegevens);
        list.add(bestelling);        

        
        return list;
}
    
    
    //Gebruikt de functie hierboven en geeft alleen een arraylist met contactgegevens terug
    public static ArrayList XmlImportGegevensFromFile(String bestandslocatie){
        XmlImportFromFile(bestandslocatie);
        return contactGegevens2;        
        
    }
    
//Gebruikt de functie hierboven en geeft alleen een arraylist met artikelen terug
    public static ArrayList XmlImportBestellingFromFile(String bestandslocatie){
        XmlImportFromFile(bestandslocatie);
        return bestelling2;
    }

        
}
