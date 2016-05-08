package BPP;

import javax.swing.*;
import java.awt.*;

public class simulatiePanel extends JPanel{
	public simulatiePanel(){
		setPreferredSize(new Dimension(1280, 720));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.WHITE);
	}
}
