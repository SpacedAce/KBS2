package BPP;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "bin")										//geeft dat aan dat het de root is met de naam 'bin'
@XmlAccessorType (XmlAccessType.FIELD)								//geeft aan dat er attributen in kunnen
public class Bin {
	int hoogte;
//	@XmlTransient													//negeert de arraylist (voor een duidelijkere opmaak en laat onnodige informatie weg)
	ArrayList<Artikel> artikelen = new ArrayList<Artikel>();		//aanmaken arralist met de naam artikelen
	int ruimte;
	
	public Bin() {
		this.hoogte = 12;											//zet de standaard hoogte van de bin op 12
		this.ruimte = 12;										//de hoogte van de bin is gelijk aan de hoogte, omdat er niks in zit
	}
	
	public void addArtikel(Artikel artikel){
		artikelen.add(artikel);
	}
	
//	public int getRuimte(){
//		for(Artikel artikel : this.artikelen){							//foreach loop door de arraylist van artikelen
//			this.ruimte -= artikel.getHoogte();						//de overgebleven ruimte is de huidige ruimte min de hoogte van het artikel
//		}
//		return ruimte;												//geeft de overgebleven ruimte terug
//	}
	
	

	public ArrayList<Artikel> getArtikelen(){
		return artikelen;
	}
	
	public void setRuimte(){
		int initialRuimte = 12;
		int inhoud = 0;
		for(Artikel artikel : artikelen){							//foreach loop door de arraylist van artikelen
			inhoud += artikel.getHoogte();							//bereken de overgebleven ruimte
		}
		this.ruimte = (initialRuimte - inhoud);
	}
	
	public int getRuimte(){
		setRuimte();
		return ruimte;
	}
	
	@Override														
	public String toString(){										//override van de toStirng
		String _return = "";										//maakt een lege string
		for(Artikel artikel : artikelen){							//loop door artikelen heen
			_return += artikel.getHoogte() + " ";					//voeg hoogte van het artikel toe aan returnwaarde
//			_return += artikel;							
		}
//		_return += " Ruimte over: " + getRuimte();
		return _return;												//geeft de returnwaarde terug
	}
}
// commit test