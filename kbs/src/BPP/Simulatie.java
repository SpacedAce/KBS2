package BPP;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Simulatie extends JFrame{
	public Simulatie(int aantalPakketten, Algoritme gekozenAlgoritme){
		setTitle("BPP Simulatie - " + aantalPakketten + " pakketten - " + gekozenAlgoritme.naam);
		setSize(1280, 720);
		
		ArrayList<pakket> pakketten = new ArrayList<pakket>();
		for(int i = 0; i < aantalPakketten; i++){
			pakketten.add(new pakket(new Random().nextInt(11) + 1));
		}
		
		int index = 0;
		for(pakket pakket : pakketten){
			System.out.println((index++ + 1) + ": " + pakket.grootte);
		}
	}
}
