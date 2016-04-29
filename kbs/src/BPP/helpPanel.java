package BPP;

import java.awt.*;
import javax.swing.*;

public class helpPanel extends JFrame{
	public helpPanel(){
		setTitle("Help");
		setSize(500, 800);
		
		ImageIcon image = new ImageIcon(getClass().getResource("helpPanelimg/hoofdscherm.png"));
		
		JLabel img = new JLabel();
		img.setIcon(image);
		img.setBounds(10, 10, 480, 240);
		add(img);
		
		setVisible(true);
	}
}
