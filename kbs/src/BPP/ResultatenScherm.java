package BPP;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ResultatenScherm extends JFrame{
	File file = null;
	private boolean hasResultaten1 = false;
	private boolean hasResultaten2 = false;
	public ResultatenScherm(){
		setTitle("BPP - Resultaten");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);																																											//geen layout manager
		setResizable(false);
		setLayout(null);

		JButton openen = new JButton("Voeg een simulatie toe");
		openen.setBounds(10, this.getHeight() - 73, 200, 25);
		openen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = System.getProperty("user.dir");
				JFileChooser fileChooser = new JFileChooser(path + "/kbs/src/BPP/Resultaten");
				int returnVal = fileChooser.showOpenDialog(getParent());
				
				if(returnVal == JFileChooser.APPROVE_OPTION){
					file = fileChooser.getSelectedFile();
					try {
						unmarshal(file);
					} catch (JAXBException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		add(openen);
		
		JButton terug = new JButton("Terug naar hoofdscherm");
		terug.setBounds(220, this.getHeight() - 73, 200, 25);
		terug.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hoofdscherm scherm1 = new hoofdscherm("BPP_Simulator");
				scherm1.setVisible(true);
				setVisible(false);
			}
		});
		add(terug);
	}
	
	public void unmarshal(File file) throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(Resultaten.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		Resultaten resultaten = (Resultaten) jaxbUnmarshaller.unmarshal(file);
		if(!(hasResultaten1)){
			addResultaten1(resultaten);
			System.out.println("resultaten 1");
		}else if(hasResultaten1 && !(hasResultaten2)){
			addResultaten2(resultaten);
			System.out.println("resultaten2");
		}else if(hasResultaten1 && hasResultaten2){
			Popup waarschuwing = new Popup("Verwijder eerst een van de twee resultaten voor een andere toe te voegen.");
		}
//		addResultaten1(resultaten);
	}
	
	public void addResultaten1(Resultaten resultaten){
		JPanel resultatenPanel = new JPanel();
		resultatenPanel.setLayout(null);
		resultatenPanel.setSize(550, 450);
		JTable tabel1 = new JTable(6, 2);
		tabel1.getColumnModel().getColumn(0).setWidth(200);
		tabel1.getColumnModel().getColumn(1).setWidth(350);
		tabel1.setValueAt("Gekozen algoritme:", 0, 0);
		tabel1.setValueAt(resultaten.getGekozenAlgoritme().getNaam(), 0, 1);
		tabel1.setValueAt("Aantal pakketten:", 1, 0);
		tabel1.setValueAt(resultaten.getAantalPakketten(), 1, 1);
		tabel1.setValueAt("Totale grootte pakketten:", 2, 0);
		tabel1.setValueAt(resultaten.getTotaleGrootte(), 2, 1);
		tabel1.setValueAt("Aantal gevulde bins:", 3, 0);
		tabel1.setValueAt(resultaten.getAantalBins(), 3, 1);
		tabel1.setValueAt("Verloren ruimte:", 4, 0);
		tabel1.setValueAt(resultaten.getVerlorenRuimte(), 4, 1);
		tabel1.setValueAt("Verstreken tijd:", 5, 0);
		tabel1.setValueAt(resultaten.getTime() / 1000 + " seconden", 5, 1);
		tabel1.setBounds(50, 100, 550, 180);
		for(int i = 0; i < tabel1.getRowCount(); i++){
			tabel1.setRowHeight(i, 30);
		}
		tabel1.setEnabled(false);
		resultatenPanel.add(tabel1);
		tabel1.setEnabled(false);
		add(resultatenPanel);
		
		JLabel sluit = new JLabel("Sluit");
		sluit.setFont(new Font("", Font.BOLD, 12));
		sluit.setBounds(50, 50, 330, 30);
		resultatenPanel.add(sluit);
		sluit.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hasResultaten1 = false;
				remove(resultatenPanel);
				System.out.println("test");
				repaint();
				System.out.println("Simulatie 1 verwijderd");
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
		revalidate();
		repaint();
//		setVisible(true);
		
		System.out.println("Aantal bins: " + resultaten.getAantalBins());
		System.out.println("Tijd: " + resultaten.getTime());
		System.out.println("Algoritme: " + resultaten.getGekozenAlgoritme().getNaam());
		hasResultaten1 = true;
	}
	
	public void addResultaten2(Resultaten resultaten){
		JPanel resultatenPanel2 = new JPanel();
		resultatenPanel2.setLayout(null);
		resultatenPanel2.setSize(550, 450);
		resultatenPanel2.setBounds(600, 0, 550, 450);
		JTable tabel2 = new JTable(6, 2);
		tabel2.getColumnModel().getColumn(0).setWidth(200);
		tabel2.getColumnModel().getColumn(1).setWidth(350);
		tabel2.setValueAt("Gekozen algoritme:", 0, 0);
		tabel2.setValueAt(resultaten.getGekozenAlgoritme().getNaam(), 0, 1);
		tabel2.setValueAt("Aantal pakketten:", 1, 0);
		tabel2.setValueAt(resultaten.getAantalPakketten(), 1, 1);
		tabel2.setValueAt("Totale grootte pakketten:", 2, 0);
		tabel2.setValueAt(resultaten.getTotaleGrootte(), 2, 1);
		tabel2.setValueAt("Aantal gevulde bins:", 3, 0);
		tabel2.setValueAt(resultaten.getAantalBins(), 3, 1);
		tabel2.setValueAt("Verloren ruimte:", 4, 0);
		tabel2.setValueAt(resultaten.getVerlorenRuimte(), 4, 1);
		tabel2.setValueAt("Verstreken tijd:", 5, 0);
		tabel2.setValueAt(resultaten.getTime() / 1000 + " seconden", 5, 1);
		tabel2.setBounds(0, 100, 550, 180);
		for(int i = 0; i < tabel2.getRowCount(); i++){
			tabel2.setRowHeight(i, 30);
		}
		tabel2.setEnabled(false);
		resultatenPanel2.add(tabel2);
		tabel2.setEnabled(false);
		add(resultatenPanel2);
		
		JLabel sluit = new JLabel("Sluit");
		sluit.setFont(new Font("", Font.BOLD, 12));
		sluit.setBounds(0, 50, 330, 30);
		resultatenPanel2.add(sluit);
		sluit.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hasResultaten2 = false;
				remove(resultatenPanel2);
				System.out.println("test");
				repaint();
				System.out.println("Simulatie 2 verwijderd");
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
		revalidate();
		repaint();
//		setVisible(true);
		
		System.out.println("Aantal bins: " + resultaten.getAantalBins());
		System.out.println("Tijd: " + resultaten.getTime());
		System.out.println("Algoritme: " + resultaten.getGekozenAlgoritme().getNaam());
		hasResultaten2 = true;
	}
}
