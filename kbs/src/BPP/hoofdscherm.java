package BPP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class hoofdscherm extends JFrame{
	private Algoritme gekozenAlgoritme;																																				//
	public boolean helpOpened = false;
	public hoofdscherm(String titel){
		setTitle(titel);																																							//zet titel van scherm
		setSize(500,250);																																							//zet grootte
		setLayout(null);																																							//geen layout manager
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel help = new JLabel("?");
		help.setFont(new Font("", Font.BOLD, 12));
		help.setBounds(getWidth() - 30, 0, 15, 15);
		add(help);
		help.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				helpPanel help1 = new helpPanel();
				helpOpened = true;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
		});
		
		JLabel _titel = new JLabel("BPP Simulator");																																//
		_titel.setFont(new Font("", Font.BOLD, 22));																																//Zet titel op scherm
		_titel.setBounds(this.getWidth()/2 - 100, 10, 150, 20);																														//
		add(_titel);																																								//

		Algoritme simpelGretig = new simpelGretig();																																//
		Algoritme firstFit = new firstFit();																																		//
		Algoritme fullBin = new fullBin();																																			//aanmaken van algoritmes
		Algoritme firstFitDecr = new firstFitDecr();																																//
		Algoritme volledigeEnum = new volledigeEnum();																																//
		JComboBox comboBox = new JComboBox(new String[] {"Kies een algoritme", simpelGretig.naam, firstFit.naam, fullBin.naam, firstFitDecr.naam, volledigeEnum.naam});				//combobox vullen met namen van algoritmes
		comboBox.setBounds(10, 50, 200, 25);																																		//zet grootte/positie van combobox
		add(comboBox);																																								//combobox op scherm
		JLabel beschrijving = new JLabel();																																			//nieuw label voor beschrijving algoritme
		beschrijving.setBounds(this.getWidth() / 2 - 35, 20, 275, 100);																												//grootte en positie van ^
		comboBox.addItemListener(new ItemListener(){																																//itemlistener maken voor de combobox
			public void itemStateChanged(ItemEvent ie) {																															//wanneer het item in de combobox verandert
				if(ie.getStateChange() == ItemEvent.SELECTED){																														//alleen voor het geselecteerde item(niet het item wat gedeselecteerd is)
					if(ie.getItem() == simpelGretig.naam){																															//als algoritme simpelGretig is...
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, simpelGretig.getBeschrijving()));								//zet beschrijving
						setVisible(true);																																			//update scherm
						gekozenAlgoritme = simpelGretig;
					}
					if(ie.getItem() == fullBin.naam){
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, fullBin.getBeschrijving()));
						setVisible(true);
						gekozenAlgoritme = fullBin;
					}
					if(ie.getItem() == firstFitDecr.naam){
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, firstFitDecr.getBeschrijving()));
						setVisible(true);
						gekozenAlgoritme = firstFitDecr;
					}
					if(ie.getItem() == firstFit.naam){
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, firstFit.getBeschrijving()));
						setVisible(true);
						gekozenAlgoritme = firstFit;
					}
					if(ie.getItem() == volledigeEnum.naam){
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, volledigeEnum.getBeschrijving()));
						setVisible(true);
						gekozenAlgoritme = volledigeEnum;
					}
					if(ie.getItem() == "Kies een algoritme"){
						beschrijving.setText("");
						setVisible(true);
					}
				}
			}			
		});
		add(beschrijving);
		JLabel pakketten = new JLabel("Aantal pakketten:");
		pakketten.setBounds(10, 100, 100, 15);
		add(pakketten);
		JTextField _pakketten = new JTextField(100);
		_pakketten.setBounds(110, 100, 100, 17);
		add(_pakketten);
		JButton start = new JButton("Start");
		start.setBounds(130, 150, 80, 20);
		add(start);
		start.addActionListener(new ActionListener(){																																//action listener op startknop
			public void actionPerformed(ActionEvent e) {	
				if(e.getSource() == start && comboBox.getSelectedItem() == "Kies een algoritme"){																					//kijk naar source en geselecteerde item in combobox
					Popup waarschuwing = new Popup("Kies een algoritme.");																											//geen algoritme gekozen = popup
				}else{
					try{
						Integer.parseInt(_pakketten.getText());																														//is er een int ingevuld?
						setVisible(false);																																			//scherm uit
						int aantalPakketten = Integer.parseInt(_pakketten.getText());																								//
						Simulatie simulatie1 = new Simulatie(aantalPakketten, gekozenAlgoritme);																										//Simulatie maken
						simulatie1.setVisible(true);
					}
					catch(NumberFormatException e2){
						Popup waarschuwing2 = new Popup("Vul een heel getal in lager dan 2147483648");																										//waarschuwing als er geen int is ingevuld
					}
				}
			}
		});
		
		Artikel artikel1 = new Artikel(1);
		Artikel artikel2 = new Artikel(10);
		Artikel artikel3 = new Artikel(5);
		ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
		artikelen.add(artikel1);
		artikelen.add(artikel2);
		artikelen.add(artikel3);
//		ArrayList<Bin> bins = firstFitDecr.firstFitDecreasing(artikelen);
//		for(Bin binLoop : bins){
//			for(Artikel artikel : binLoop.artikelen){
//				System.out.println(artikel.toString());
//			}
//		}
		
	}
}