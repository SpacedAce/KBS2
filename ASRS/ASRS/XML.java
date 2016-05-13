/**
 * Charlene Hoogkamer
 * s1092106
 * ICTm2b
 */

package ASRS;

import javax.swing.*;

public class XML extends JPanel{
    private JLabel jlXML;
    protected JTextArea jtaXML;
    private JScrollPane jspXML;
        
    public XML() {       
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //Lay-out manager bepalen, BoxLayout gebruikt omdat dan alles makkelijk onder elkaar kan worden gezet (Y-AXIS)
        
        jlXML = new JLabel("XML" /* + ordernummer */); //Label XML toevoegen
        add(jlXML);
  
        jtaXML = new JTextArea(10, 30); //textArea voor de pakbon toevoegen
        add(jtaXML);
        jtaXML.setEditable(false); //Zorgen dat er niet in de textArea getypt kan worden
        
        jspXML = new JScrollPane(jtaXML); //Aanmaken van een scrollPane en de textArea hieraan toevoegen
        add(jspXML);    
    } 
}
    
