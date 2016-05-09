package BPP;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Artikelen {
	ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
	
	public Artikelen(){
		
	}
	
	public void setArtikelen(ArrayList<Artikel> artikelen){
		this.artikelen = artikelen;
	}
	
	@XmlElement(name = "Artikel")
	public ArrayList<Artikel> getArtikelen(){
		return artikelen;
	}
}
