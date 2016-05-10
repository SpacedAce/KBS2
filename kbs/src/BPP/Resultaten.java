package BPP;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Resultaten")								//geeft dat aan dat het de root is met de naam 'resultaten'
@XmlAccessorType (XmlAccessType.FIELD)								//geeft aan dat er attributen in kunnen
public class Resultaten {
	Algoritme gekozenAlgoritme;
	int aantalPakketten;
	int totaleGrootte;
	int verlorenRuimte;
	float time;														
	int aantalBins;
	List<Bin> bin = new ArrayList<Bin>();

	public int getAantalBins(){
		return bin.size();											//zet het aantal bins dat gebruikt wordt in de reultaten van het xml bestand
	}
	
	public void setAantalBins(){
		this.aantalBins = bin.size();								//berekend het aantal bins
	}
	
	public List<Bin> getBins(){
		return bin;													//geeft een lijst van bins terug
	}
	
	@XmlElement(name = "bin")										//geeft aan dat bin een element is en geen attribuut
	public void setBins(ArrayList<Bin> bins){
		this.bin = bins;											//--
	}
	
	public float getTime() {
		return time;												//geeft de verwerktijd van de simulatie terug
	}

	public void setTime(float time) {
		this.time = time;											//--
	}

	public Algoritme getGekozenAlgoritme() {
		return gekozenAlgoritme;
	}

	public void setGekozenAlgoritme(Algoritme gekozenAlgoritme) {
		this.gekozenAlgoritme = gekozenAlgoritme;
	}

	public int getAantalPakketten() {
		return aantalPakketten;
	}

	public void setAantalPakketten(int aantalPakketten) {
		this.aantalPakketten = aantalPakketten;
	}

	public int getTotaleGrootte() {
		return totaleGrootte;
	}

	public void setTotaleGrootte(int totaleGrootte) {
		this.totaleGrootte = totaleGrootte;
	}

	public int getVerlorenRuimte() {
		return verlorenRuimte;
	}

	public void setVerlorenRuimte() {
		this.verlorenRuimte = (aantalBins * 12) - totaleGrootte + 1;
	}
}
