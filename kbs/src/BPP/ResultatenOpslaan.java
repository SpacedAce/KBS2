package BPP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ResultatenOpslaan {
	
	public void saveToXML(float time, ArrayList<Bin> bins){
		
		ArrayList<Bin> bins_ = new ArrayList<Bin>();
		
		for(Bin bin : bins){
			
		}
		
//		Artikelen artikelen = new Artikelen();
//		ArrayList<Artikel> _artikelen = new ArrayList<Artikel>();
//		
//		Artikel artikel1 = new Artikel();		//creeer artikelen
//		Artikel artikel2 = new Artikel();
//		artikel1.setHoogte(10);					//zet hoogte
//		artikel2.setHoogte(5);
//		
//		ArrayList<Bin> _bins = new ArrayList<Bin>();
//		_bins.add(new Bin());					//creeer bins
//		_bins.add(new Bin());
//		
//		_artikelen.add(artikel1);				//zet artikel1 in list
//		Artikelen artikelen1 = new Artikelen();	//creeer artikelen houder
//		artikelen1.setArtikelen(_artikelen);	//zet lijst artikelen in artikelen houder
//		_bins.get(0).setArtikelen(artikelen1);	//zet artikelen houder in bin
//		_artikelen.add(artikel2);				//voeg artikel 2 toe aan lijst
//		Artikelen artikelen2 = new Artikelen();	//creeer nieuwe artikel houder
//		artikelen2.setArtikelen(_artikelen);	//voeg bijgewerkte artikelen lijst toe aan artikkelen houder
//		bins.get(1).setArtikelen(artikelen1);	//zet nieuwe artikelen houder in bin 2
		
		Resultaten resultaten = new Resultaten();	//creeer resultaten object
		resultaten.setTime(time);					//zet tijd
		resultaten.setBins(bins);					//zet array bins in resultaten object
		resultaten.setAantalBins();
		try{
			File file = new File("C:/Users/Kevin/Documents/GitHub/KBS2/kbs/src/BPP/test.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Resultaten.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(resultaten, file);
			jaxbMarshaller.marshal(resultaten, System.out);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
