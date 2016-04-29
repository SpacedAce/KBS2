package BPP;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class helpPanel extends JFrame{
	public helpPanel(){
		setTitle("Help");
		setSize(500, 800);
		setLayout(new FlowLayout());
		
		ImageIcon image = new ImageIcon(getClass().getResource("helpPanelimg/hoofdscherm2.png"));
		JLabel img = new JLabel();
		img.setIcon(image);
		img.setBounds(10, 10, 350, 240);
		img.setBorder(new EmptyBorder(0, 10, 0, 10));
		add(img);
		String _text = "<p>1 (kies een algoritme): Hier kunt u een algoritme kiezen om te gebruiken in de simulatie. Door op het pijltje te klikken opent u een menu waar u een algoritme kunt selecteren.</p><br>" 
				+ "<p>2 (aantal pakketten): Hier kunt u het aantal pakketten kiezen dat gebruikt gaat worden in de simulatie. De ingoevoerde waarden moeten tussen 1 en 2147483647 liggen.</p><br>"
				+ "<p>3 (start): klik op deze knop om de simulatie te starten. U kunt pas een simulatie starten als u (1) een algoritme heeft geselecteerd en (2) u een waarde groter dan 1 en kleiner dan 2147483647 heeft ingevoerd.</p><br>"
				+ "<p>4 (?): klik op het vraagteken als u het hulpscherm van het hoofdscherm wilt openen.</p>";
		JLabel text =  new JLabel(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 360, _text));
		text.setBounds(10, 250, 480, 540);
		add(text);
		pack();
		setVisible(true);
	}
}
