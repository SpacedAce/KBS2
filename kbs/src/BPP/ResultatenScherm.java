package BPP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ResultatenScherm extends JFrame{
	File file = null;
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
				JFileChooser fileChooser = new JFileChooser("C:/Users/Kevin/Documents/GitHub/KBS2/kbs/src/BPP/Resultaten");
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
	}
	
	public void unmarshal(File file) throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(Resultaten.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		Resultaten resultaten = (Resultaten) jaxbUnmarshaller.unmarshal(file);
		
		System.out.println("Aantal bins: " + resultaten.getAantalBins());
		System.out.println("Tijd: " + resultaten.getTime());
	}
}
