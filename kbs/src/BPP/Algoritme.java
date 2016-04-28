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
		return null;
	}
}
