package BPP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.*;


public class Simulatie extends JFrame{
	JButton resultaten = new JButton();
	ArrayList<Bin> bins = null;
	int totaleGrootte;
	public Simulatie(){
		System.out.println("test");
	}
	public Simulatie(int aantalPakketten, Algoritme gekozenAlgoritme){
		setTitle("BPP Simulatie - " + aantalPakketten + " pakketten - " + gekozenAlgoritme.getNaam());
		setTitle(this.getClass().getSimpleName());
		setSize(1280, 720);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel aantalBins = new JLabel();
		aantalBins.setBounds(this.getWidth() - 150, 150, 200, 25);
		add(aantalBins);
		JLabel time = new JLabel();
		time.setBounds(this.getWidth() - 150, 175, 200, 25);
		add(time);
		
		
		ArrayList<Artikel> pakketten = new ArrayList<Artikel>();
		for(int i = 0; i < aantalPakketten; i++){
			pakketten.add(new Artikel(new Random().nextInt(11) + 1));
		}

		for(Artikel artikel : pakketten){
			totaleGrootte += artikel.getHoogte();
			
		}
//		int index = 0;
//		for(Artikel pakket : pakketten){
//			System.out.println((index++ + 1) + ": " + pakket.getHoogte());
//		}
		
		if(gekozenAlgoritme.getNaam() == "First fit decreasing"){													//
			bins = gekozenAlgoritme.firstFitDecreasing(pakketten);													//
		}else if(gekozenAlgoritme.getNaam() == "Simpel gretig"){													//
			bins = gekozenAlgoritme.simpelGretig(pakketten);														//
		}else if(gekozenAlgoritme.getNaam() == "Full bin packing"){													//
			bins = gekozenAlgoritme.fullBin(pakketten);																//Execute proper algorithm
		}else if(gekozenAlgoritme.getNaam() == "Volledige enumeratie"){												//
			bins = gekozenAlgoritme.volledigeEnum(pakketten);														//
		}else if(gekozenAlgoritme.getNaam() == "First fit packing"){												//
			bins = gekozenAlgoritme.simpelGretig(pakketten);														//
		}																											//
		int _aantalBins = 0;
//		System.out.println("debug");
		Iterator<Bin> i = bins.iterator();
		while(i.hasNext()){
			Bin b = i.next();
			if(b.getArtikelen().isEmpty()){
				i.remove();
			}
		}
		for(Bin bin : bins){
//			System.out.println(bin.toString());																		//test
			if(!(bin.getArtikelen().isEmpty())){
				_aantalBins++;
			}
		}
		System.out.println("Aantal bins: " + _aantalBins);															//
		String _bins = "" + _aantalBins + " bins";																	//
		aantalBins.setText(_bins);																					//
		float elapsedTime = gekozenAlgoritme.getTime();																//Get useful data and put it on-screen
		System.out.println(elapsedTime + " milliseconden");															//
		String timeLabel = "Tijd: " + elapsedTime / 1000 + " seconden";												//
		time.setText(timeLabel);																					//
		resultaten.setText("Resultaten");
		resultaten.setBounds(this.getWidth() - 158, this.getHeight() - 65, 140, 25);
		resultaten.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == resultaten){
//					System.out.println("test");
//					setVisible(false);
//					ResultatenOpslaan resultaten = new ResultatenOpslaan();
//					resultaten.saveToXML(elapsedTime, bins, gekozenAlgoritme, aantalPakketten, totaleGrootte);
//					ResultatenScherm resultsScreen = new ResultatenScherm();
//					resultsScreen.setVisible(true);
//					resultaten.setBins(bins);
//					resultaten.setTime(elapsedTime);
//					resultaten.setVisible(true);
				}
			}
			
		});
		add(resultaten);
		simulatiePanel simulatie = new simulatiePanel();
		simulatie.setBounds(0, 100, 1080, 520);
		add(simulatie);
		setVisible(true);
		simulatie.setResultaten(bins);
		setVisible(false);
		Popup melding = new Popup("De resultaten van deze simulatie zijn opgeslagen.");
		ResultatenOpslaan resultaten = new ResultatenOpslaan();
		resultaten.saveToXML(elapsedTime, bins, gekozenAlgoritme, aantalPakketten, totaleGrootte);
		ResultatenScherm resultsScreen = new ResultatenScherm();
		resultsScreen.setVisible(true);
		Resultaten _resultaten = new Resultaten();
		_resultaten.setBins(bins);
		_resultaten.setAantalBins();
		_resultaten.setGekozenAlgoritme(gekozenAlgoritme);
		_resultaten.setTime(elapsedTime);
		_resultaten.setAantalPakketten(aantalPakketten);
		_resultaten.setTotaleGrootte(totaleGrootte);
		_resultaten.setVerlorenRuimte();
		resultsScreen.addResultaten1(_resultaten);
//		simulatie.animate();
	}
}
