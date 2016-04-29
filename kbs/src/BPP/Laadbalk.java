package BPP;

import java.awt.*;
import javax.swing.*;

public class Laadbalk extends JFrame{
	int max;
	
	public Laadbalk(int max){
		this.max = max;
		setSize(500, 250);
		setTitle("Pakketten genereren");
		setVisible(true);
		tekenPanel panel1 = new tekenPanel(new Dimension(350,50));
	}
}
