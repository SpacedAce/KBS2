package BPP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Algoritme extends Timer{
	private String naam;
	String beschrijving;
	long startTime;
	long endTime;
	float elapsedTime;
	
	public String getBeschrijving(){
		return beschrijving;
	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public ArrayList<Bin> firstFitDecreasing(ArrayList<Artikel> artikelen){
		startTime = startTimer();														//get start time
		Collections.sort(artikelen);													//sort arraylist
//		System.out.println(Arrays.toString(artikelen.toArray()));
		ArrayList<Bin> bins = new ArrayList<Bin>(); 									//create bins arraylist
		bins.add(new Bin());															//add 1st bin
		for(Artikel artikel : artikelen){												//loop 1st arraylist
			for(Bin bin : bins){														//loop 2nd arraylist
				if(artikel.getHoogte() <= bin.getRuimte() && !(artikel.isVerwerkt())){	//check if product fits the bin
					bin.addArtikel(artikel);											//add product to bin
					artikel.gevuld();													//make sure product isn't filled twice
				}
//				System.out.println(bin.toString());
			}
//			System.out.println("Bin gevuld");
			bins.add(new Bin());														//add new bin
		}
//		bins.remove(bins.size() - 1);
		endTime = endTimer();															//get end time
		elapsedTime = calculateTime(startTime, endTime);								//calculate elapsed time
		return bins;																	//return bins list
	}
	
	public ArrayList<Bin> simpelGretig(ArrayList<Artikel> artikelen){					//same as firstFitDecr but not sorted, same as firstFit(not making firstFit, instead using this)
		startTime = startTimer();														//get start time
//		System.out.println(Arrays.toString(artikelen.toArray()));
		ArrayList<Bin> bins = new ArrayList<Bin>(); 									//create bins arraylist
		bins.add(new Bin());															//add 1st bin
		for(Artikel artikel : artikelen){												//loop 1st arraylist
			for(Bin bin : bins){														//loop 2nd arraylist
				if(artikel.getHoogte() <= bin.getRuimte() && !(artikel.isVerwerkt())){								//check if product fits the bin
					bin.addArtikel(artikel);											//add product to bin
					artikel.gevuld();
				}
			}
			bins.add(new Bin());														//add new bin
		}
//		bins.remove(bins.size() - 1);													//remove last(empty) bin
		endTime = endTimer();															//get end time
		elapsedTime = calculateTime(startTime, endTime);								//calculate elapsed time
		return bins;																	//return bins list
	}
	
	public ArrayList<Bin> fullBin(ArrayList<Artikel> artikelen){
		startTime = startTimer();														//get start time
		ArrayList<Bin> bins = new ArrayList<Bin>(); 									//create bins arraylist
		bins.add(new Bin());															//add 1st bin
		
		//process list of products
		
		endTime = endTimer();															//get end time
		elapsedTime = calculateTime(startTime, endTime);								//calculate elapsed time
		return bins;																	//return bins list
	}
	
	public ArrayList<Bin> volledigeEnum(ArrayList<Artikel> artikelen){
		startTime = startTimer();														//get start time
		ArrayList<Bin> bins = new ArrayList<Bin>(); 									//create bins arraylist
		bins.add(new Bin());															//add 1st bin
		
		//process list of products
		
		endTime = endTimer();															//get end time
		elapsedTime = calculateTime(startTime, endTime);								//calculate elapsed time
		return bins;																	//return bins list
	}
	
	public float getTime(){
		return elapsedTime;
	}
}
// commit test
