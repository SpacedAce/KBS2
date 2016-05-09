import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
 
public class JavaSwingColorPicker extends JFrame {
     
    MyRxTx myRxTx;
 
    public JavaSwingColorPicker() {
        super("JColorChooser Test Frame");
        setSize(200, 100);
        final Container contentPane = getContentPane();
        final JButton go = new JButton("Show JColorChooser");
        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color c;
                c = JColorChooser.showDialog(
                        ((Component) e.getSource()).getParent(),
                        "Demo", Color.blue);
                contentPane.setBackground(c);
 
                byte byteR = (byte)(c.getRed());
                byte byteG = (byte)(c.getGreen());
                byte byteB = (byte)(c.getBlue() );
                 
                try {
                    byte[] bytesToSent = 
                            new byte[]{byteB, byteG, byteR};
                    myRxTx.output.write(bytesToSent);
                     
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
        });
        contentPane.add(go, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
        myRxTx = new MyRxTx();
        myRxTx.initialize();
    }
}
