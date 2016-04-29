package BPP;

import javax.swing.*;

public class Popup extends JDialog{
	public Popup(String message){
		JOptionPane dialog = new JOptionPane();
		dialog.showMessageDialog(null, message);
	}
}
