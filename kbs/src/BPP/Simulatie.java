package BPP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Simulatie extends JFrame implements ActionListener{
	JButton resultaten = new JButton();
	public Simulatie(int aantalPakketten, Algoritme gekozenAlgoritme){
		setTitle("BPP Simulatie - " + aantalPakketten + " pakketten - " + gekozenAlgoritme.getNaam());
//		setTitle(this.getClass().getSimpleName());
		setSize(1280, 720);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simulatiePanel simulatie = new simulatiePanel();
		add(simulatie);
		JLabel aantalBins = new JLabel();
		aantalBins.setBounds(this.getWidth() - 250, 150, 200, 25);
		add(aantalBins);
		JLabel time = new JLabel();
		time.setBounds(this.getWidth() - 250, 175, 200, 25);
		add(time);
		resultaten.setText("Resultaten");
		resultaten.setBounds(this.getWidth() - 158, this.getHeight() - 65, 140, 25);
		resultaten.addActionListener(this);
		add(resultaten);
		
		ArrayList<Artikel> pakketten = new ArrayList<Artikel>();
		for(int i = 0; i < aantalPakketten; i++){
			pakketten.add(new Artikel(new Random().nextInt(11) + 1));
		}

//		int index = 0;
//		for(Artikel pakket : pakketten){
//			System.out.println((index++ + 1) + ": " + pakket.getHoogte());
//		}
		
		ArrayList<Bin> bins = null;
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
		for(Bin bin : bins){
			System.out.println(bin.toString());																		//test
			if(!(bin.getArtikelen().isEmpty())){
				_aantalBins++;
			}
			System.out.println(_aantalBins);
		}
		System.out.println("debug");
		System.out.println("Aantal bins: " + _aantalBins);															//
		String _bins = "" + _aantalBins + " bins";																	//
		aantalBins.setText(_bins);																					//
		float elapsedTime = gekozenAlgoritme.getTime();																//Get useful data and put it on-screen
		System.out.println(elapsedTime + " milliseconden");															//
		String timeLabel = "Tijd: " + elapsedTime / 1000 + " seconden";												//
		time.setText(timeLabel);																					//
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == resultaten){
			System.out.println("test");
			setVisible(false);
			Resultaten resultaten = new Resultaten();
			resultaten.setVisible(true);
		}
	}
}
