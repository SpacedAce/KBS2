package BPP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class hoofdscherm extends JFrame{
	public hoofdscherm(String titel){
		setTitle(titel);
		setSize(500,250);
		setLayout(null);
		
		JLabel _titel = new JLabel("BPP Simulator");
		_titel.setFont(new Font("", Font.BOLD, 22));
		_titel.setBounds(this.getWidth()/2 - 50,10,100,20);
		add(_titel);

		Algoritme simpelGretig = new simpelGretig();
		Algoritme firstFit = new firstFit();
		Algoritme fullBin = new fullBin();
		Algoritme firstFitDecr = new firstFitDecr();
		Algoritme volledigeEnum = new volledigeEnum();
		JComboBox comboBox = new JComboBox(new String[] {"Kies een algoritme", simpelGretig.naam, firstFit.naam, fullBin.naam, firstFitDecr.naam, volledigeEnum.naam});
		comboBox.setBounds(10, 50, 200, 25);
		add(comboBox);
		JLabel beschrijving = new JLabel();
		beschrijving.setBounds(this.getWidth() / 2 - 35, 20, 275, 100);
		comboBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie) {
				if(ie.getStateChange() == ItemEvent.SELECTED){
					if(ie.getItem() == simpelGretig.naam){
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, simpelGretig.getBeschrijving()));
						setVisible(true);
					}
					if(ie.getItem() == fullBin.naam){
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, fullBin.getBeschrijving()));
						setVisible(true);
					}
					if(ie.getItem() == firstFitDecr.naam){
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, firstFitDecr.getBeschrijving()));
						setVisible(true);
					}
					if(ie.getItem() == firstFit.naam){
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, firstFit.getBeschrijving()));
						setVisible(true);
					}
					if(ie.getItem() == volledigeEnum.naam){
						beschrijving.setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 200, volledigeEnum.getBeschrijving()));
						setVisible(true);
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
	}
}
