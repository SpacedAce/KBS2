package BPP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

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
				if(artikel.getHoogte() <= bin.getRuimte() && !(artikel.isVerwerkt())){	//check if product fits the bin
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
		startTime = startTimer();																		//Zet de starttijd van de simulatie.
		Collections.sort(artikelen);																	//Sorteert de ArrayList van groot naar klein.
		ArrayList<Bin> bins = new ArrayList<Bin>();														//Maakt een nieuwe ArrayList bins aan.
		bins.add(new Bin());																			//Voegt de eerste bin toe.
		ArrayList<Artikel> gesorteerd = new ArrayList<>();
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 12) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 11) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 1) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 10) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 2) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 9) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 3) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 8) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 4) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 7) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 5) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel artikel : artikelen){
			if((artikel.getHoogte() == 6) && !(artikel.isVerwerkt())){
				gesorteerd.add(artikel);
			}
		}
		for(Artikel sort : gesorteerd){
			if(!(sort.isVerwerkt())){
				for(Bin bin : bins){
					if((sort.getHoogte() == bin.getRuimte()) && !(sort.isVerwerkt())){			//Als de grootte van het artikel gelijk is aan de beschikbare ruimte en het artikel is nog niet verwerkt, dan geldt de if-statement.
						bin.addArtikel(sort);													//Voegt het artikel toe aan de bin.
						sort.gevuld();															//Laat weten dat het artikel verwerkt is en niet meer gebruikt kan worden in de foreach-loop.
					}else if((sort.getHoogte() < bin.getRuimte()) && !(sort.isVerwerkt())){		//Als de grootte van het artikel kleiner is dan de beschikbare ruimte en het artikel is nog niet verwerkt, dan geldt de if-statement.
						bin.addArtikel(sort);													//Voegt het artikel toe aan de bin.
						sort.gevuld();															//Laat weten dat het artikel verwerkt is en niet meer gebruikt kan worden in de foreach-loop.
					}
				}
			}
			bins.add(new Bin());
		}
		endTime = endTimer();																	//Zet de eindtijd van de simulatie.
		elapsedTime = calculateTime(startTime, endTime);										//Berekent de verstreken tijd met de starttijd en de eindtijd.
		return bins;																			//Geeft een lijst van alle gevulde bins terug.
	}
	
	
	public ArrayList<Bin> volledigeEnum(ArrayList<Artikel> artikelen){
		startTime = startTimer();														//get start time
		ArrayList<Bin> bins = new ArrayList<Bin>(); 									//create bins arraylist
		bins.add(new Bin());															//add 1st bin
		
		endTime = endTimer();															//get end time
		elapsedTime = calculateTime(startTime, endTime);								//calculate elapsed time
		return bins;																	//return bins list
	}
	
	public float getTime(){
		return elapsedTime;
	}
}