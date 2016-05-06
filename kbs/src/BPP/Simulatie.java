package BPP;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Simulatie extends JFrame{
	public Simulatie(int aantalPakketten, Algoritme gekozenAlgoritme){
		setTitle("BPP Simulatie - " + aantalPakketten + " pakketten - " + gekozenAlgoritme.naam);
//		setTitle(this.getClass().getSimpleName());
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<Artikel> pakketten = new ArrayList<Artikel>();
		for(int i = 0; i < aantalPakketten; i++){
			pakketten.add(new Artikel(new Random().nextInt(11) + 1));
		}
		
		ArrayList<Bin> bins;
		if(gekozenAlgoritme.naam == "First fit decreasing"){
			bins = gekozenAlgoritme.firstFitDecreasing(pakketten);
			int aantalBins = 0;
			for(Bin bin : bins){
				System.out.println(bin.toString());
				aantalBins++;
			}
			System.out.println("Aantal bins: " + aantalBins);
		}
//		
//		int index = 0;
//		for(pakket pakket : pakketten){
//			System.out.println((index++ + 1) + ": " + pakket.grootte);
//		}
	}
}
