package BPP;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class SimulatieFrame extends JFrame{
	public SimulatieFrame(Simulatie simulatie){
		setTitle("BPP Simulatie - " + "" + " pakketten - " + "");
//		setTitle(this.getClass().getSimpleName());
		setSize(1280, 720);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(simulatie);
		pack();
		setVisible(true);
	}
}
