package BPP;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "bin")
@XmlAccessorType (XmlAccessType.FIELD)
public class Bin {
	int hoogte;
	@XmlTransient
	ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
	int ruimte;
	
	public Bin() {
		this.hoogte = 12;
		this.ruimte = hoogte;
	}
	
	public int getRuimte(){
		for(Artikel artikel : artikelen){
			this.ruimte -= artikel.getHoogte();
		}
		return ruimte;
	}
	
	public void setRuimte(){
		for(Artikel artikel : artikelen){
			this.ruimte -= artikel.getHoogte();
		}
	}
	
	@Override
	public String toString(){
		String _return = "";
		for(Artikel artikel : artikelen){
			_return += artikel.getHoogte() + " ";
//			_return += artikel;
		}
		return _return;
	}
}
// commit test