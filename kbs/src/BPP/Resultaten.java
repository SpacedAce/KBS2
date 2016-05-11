package BPP;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Resultaten")								//Geeft dat aan dat het de root is met de naam 'Resultaten'.
@XmlAccessorType (XmlAccessType.FIELD)								//Geeft aan dat er attributen in kunnen.
public class Resultaten {
	Algoritme gekozenAlgoritme;
	int aantalPakketten;
	int totaleGrootte;
	int verlorenRuimte;
	float time;														
	int aantalBins;
	List<Bin> bin = new ArrayList<Bin>();

	public int getAantalBins(){
		return bin.size();											//Zet het aantal bins dat gebruikt wordt in de reultaten van het XML-bestand.
	}
	
	public void setAantalBins(){
		this.aantalBins = bin.size();								//Berekent het aantal bins.
	}
	
	public List<Bin> getBins(){
		return bin;													//Geeft een lijst van bins terug.
	}
	
	@XmlElement(name = "bin")										//Geeft aan dat bin een element is en geen attribuut.
	public void setBins(ArrayList<Bin> bins){
		this.bin = bins;											
	}
	
	public float getTime() {
		return time;												//Geeft de verwerktijd van de simulatie terug.
	}

	public void setTime(float time) {
		this.time = time;											//Zet de verwerktijd van de simulatie.
	}

	public Algoritme getGekozenAlgoritme() {
		return gekozenAlgoritme;									//Geeft het door de gebruiker geselecteerde algortime terug.
	}

	public void setGekozenAlgoritme(Algoritme gekozenAlgoritme) {
		this.gekozenAlgoritme = gekozenAlgoritme;					//Zet het geselecteerde algortime welke gebruikt gaat worden voor de simulatie.
	}

	public int getAantalPakketten() {
		return aantalPakketten;										//Geeft het aantal pakketten terug.
	}

	public void setAantalPakketten(int aantalPakketten) {
		this.aantalPakketten = aantalPakketten;						//Zet het aantal pakketten dat gebruikt gaat worden in de simulatie
	}

	public int getTotaleGrootte() {
		return totaleGrootte;										//Geeft de grootte van alle pakketten (bij elkaar opgeteld) terug.
	}

	public void setTotaleGrootte(int totaleGrootte) {
		this.totaleGrootte = totaleGrootte;							//Zet de totale grootte van de pakketten (bij elkaar opgeteld).
	}

	public int getVerlorenRuimte() {
		return verlorenRuimte;										//Geeft de ruimte terug die niet meer gevuld kon worden door artikelen.
	}

	public void setVerlorenRuimte() {
		this.verlorenRuimte = (aantalBins * 12) - totaleGrootte + 1;	//Zet de verloren ruimte door het aantal bin te vermenigvulding met de grootte van de bin en daar de totale grootte van de pakketten van af te trekken.
	}
}
