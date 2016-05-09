package BPP;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement																						//is een xml root element
public class Artikel implements java.lang.Comparable<Artikel>{
	private int hoogte;

	public Artikel(){
		
	}
	
	public Artikel(int hoogte) {
		this.hoogte = hoogte;
	}
	
	public void setHoogte(int hoogte){
		this.hoogte = hoogte;
	}
	
	@Override
	public int compareTo(Artikel o) {
		if(this.hoogte == o.hoogte){
			return 0;		//het artikel blijft op dezelfde plaats in de lijst staan
		}else if(this.hoogte < o.hoogte){
			return 1;		//het artikel schuift een plaats op naar boven in de lijst
		}else{
			return -1;		//het artikel schuift een plaats op naar beneden in de lijst
		}
	}

	public int getHoogte() {
		return hoogte;
	}
}
// commit test