import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class Scherm extends JFrame implements ActionListener {
	private JButton jbAan;
	private JButton jbUit;
	private boolean aanOk;
	private boolean uitOk;
	public TestClass t;

	public Scherm() {
		setSize(400, 200);
		setTitle("LED-besturing");
		setLayout(new FlowLayout());

		jbAan = new JButton("Aan");
		add(jbAan);
		jbAan.addActionListener(this);

		jbUit = new JButton("Uit");
		add(jbUit);
		jbUit.addActionListener(this);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbAan) {

		}
		if (e.getSource() == jbUit) {
			
		}
	}
	
	public boolean getAanOk() {
		return aanOk;
	}
	
	public boolean getUitOk() {
		return uitOk;
	}

}
