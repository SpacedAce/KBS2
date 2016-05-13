package BPP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class simulatiePanel extends JPanel{
	private ArrayList<Bin> resultaten;
	private boolean stop;
	private int aantalArtikelen;
	private int index;
	private int startX;
	private int startY;
	private int xPos;
	private int yPos;
	
	public simulatiePanel(){
		setPreferredSize(new Dimension(1080, 720));
		stop = false;
		aantalArtikelen = 0;
		index = 0;
		startX = 60;
		startY = 260;
		xPos = startX;
		yPos = startY;
	}
	
	public void setResultaten(ArrayList<Bin> resultaten) {
		this.resultaten = resultaten;
		System.out.println("test");
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		g.drawRect(250, 150, 700, 100);		//draw first bin
		g.drawRect(250, 350, 700, 100);		//draw second bin
		g.drawRect(50, 250, 300, 100);		//draw track
		g.drawString("Bak 1", 250, 140);
		g.drawString("Bak 2", 250, 465);
		g.drawString("Inhoud:", 850, 140);
		g.drawString("Inhoud:", 850, 465);
		System.out.println(aantalArtikelen);
		g.fillRoundRect(xPos, yPos, 75, 75, 10, 10);
	}
	
	public void animate(){
		while(true){
			for(Bin bin : resultaten){
				ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
				artikelen = bin.getArtikelen();
				for(Artikel artikel : artikelen){
					aantalArtikelen++;
				}
	//			System.out.println(aantalArtikelen);
				index++;
			}
			for(int i = 0; i < aantalArtikelen; i++){
				for(int j = 0; j < 10; j++){
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					xPos += 20;
					repaint();
				}
				if(index % 2 == 0){
					
				}
			}
		}
	}
}
