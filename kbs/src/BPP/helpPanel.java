package BPP;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class helpPanel extends JFrame{
	public helpPanel(){
		setTitle("Help");
		setSize(600, 800);
		setLayout(new FlowLayout());
		
		ImageIcon image = new ImageIcon(getClass().getResource("helpPanelimg/hoofdscherm.png"));
		JLabel img = new JLabel();
		img.setIcon(image);
//		img.setBounds(10, 10, 480, 240);
		img.setBorder(new EmptyBorder(10, 50, 10, 50));
		add(img);
		
		setVisible(true);
	}
}
