package BPP;

import java.awt.*;
import javax.swing.*;

public class tekenPanel extends JPanel{
	public tekenPanel(Dimension size){
		setPreferredSize(size);
		
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
	}
}
