package BPP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ResultatenOpslaan {
	
	public void saveToXML(float time, ArrayList<Bin> bins, Algoritme gekozenAlgoritme, int aantalPakketten, int totaleGrootte){
		
		Resultaten resultaten = new Resultaten();	//creeer resultaten object
		resultaten.setTime(time);					//zet tijd
		resultaten.setBins(bins);					//zet array bins in resultaten object
		resultaten.setAantalBins();
		resultaten.setGekozenAlgoritme(gekozenAlgoritme);
		resultaten.setAantalPakketten(aantalPakketten);
		resultaten.setTotaleGrootte(totaleGrootte);
		resultaten.setVerlorenRuimte();
		
		try{
			String path = System.getProperty("user.dir");
			path += "/kbs/src/BPP/Resultaten/";
			int files = new File(path).listFiles().length;										//Kijk hoeveel bestanden er in de map staan
			String filename = "resultaten" + (files + 1);										//genereer bestandsnaam
			File file = new File(path + filename + ".xml");										//creëer bestand
			JAXBContext jaxbContext = JAXBContext.newInstance(Resultaten.class);				//het object resultaten vertalen naar xml
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();							//object wat xml bestand genereerd
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);					//opmaak van het xml bestand maken
			
			jaxbMarshaller.marshal(resultaten, file);											//genereren van het xml bestand
			jaxbMarshaller.marshal(resultaten, System.out);										//weergeven van het xml bestand in de console
			System.out.println(file);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
