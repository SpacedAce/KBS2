import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.zu.ardulink.Link;
import org.zu.ardulink.gui.DigitalPinStatus;
import org.zu.ardulink.gui.PWMController;
import org.zu.ardulink.gui.customcomponents.ModifiableSignalButton;
import org.zu.ardulink.protocol.IProtocol;



@SuppressWarnings("deprecation")
public class Tutorial1 extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JButton jbAan;
    private JButton jbUit;
    
    Link link = Link.getDefaultInstance(); // 1

    public Tutorial1() throws InterruptedException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 475, 375);
        setLayout(new FlowLayout());

        contentPane = new JPanel();
        setContentPane(contentPane);

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
		int powerHIGH = IProtocol.HIGH;
		int powerLOW = IProtocol.LOW;
		System.out.println("Send power:" + powerHIGH);
        link.sendPowerPinSwitch(2, powerHIGH); // 5
		if(e.getSource() == jbAan) {
			link.sendPowerPinSwitch(2, powerHIGH);
		}
		if(e.getSource() == jbUit) {
			link.sendPowerPinSwitch(2, powerLOW);
		}
		// TODO Auto-generated method stub
		
	}

}