package BPP;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Resultaten")
@XmlAccessorType (XmlAccessType.FIELD)
public class Resultaten {
	float time;
	List<Bin> bins = new ArrayList<Bin>();
	int aantalBins;

	public int getAantalBins(){
		return bins.size();
	}
	
	public void setAantalBins(){
		this.aantalBins = bins.size();
	}
	
	public List<Bin> getBins(){
		return bins;
	}
	
	@XmlElement(name = "bin")
	public void setBins(ArrayList<Bin> bins){
		this.bins = bins;
	}
	
	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}
}
