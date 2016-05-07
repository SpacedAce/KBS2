package BPP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Algoritme {
	String naam;
	String beschrijving;
	
	public String getBeschrijving(){
		return beschrijving;
	}
	
	public ArrayList<Bin> firstFitDecreasing(ArrayList<Artikel> artikelen){
		Collections.sort(artikelen);
		System.out.println(Arrays.toString(artikelen.toArray()));
		ArrayList<Bin> bins = new ArrayList<Bin>(); 
		bins.add(new Bin());
		for(Artikel artikel : artikelen){
			for(Bin bin : bins){
				if(artikel.getHoogte() <= bin.getRuimte()){
					bin.artikelen.add(artikel);
				}
			}
			bins.add(new Bin());
		}
		bins.remove(bins.size() - 1);
		return bins;
	}
}
// commit test
