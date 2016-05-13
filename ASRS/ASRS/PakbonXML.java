/**
 * Charlene Hoogkamer
 * s1092106
 * ICTm2b
 */

package ASRS;

import java.awt.*;
import javax.swing.*;


public class PakbonXML extends JPanel{ //Aan dit Panel worden twee panels toegevoegd(Pakbon en XML), hierdoor is het maken van de lay-out makkelijker
    private Pakbon jpPakbon;
    private XML jpXML;
    private Scherm scherm;
            
    public PakbonXML(Scherm scherm) {
        this.scherm = scherm;
        setLayout(new BorderLayout()); //Lay-out manager kiezen
        
        jpPakbon = new Pakbon(this); 
        jpXML = new XML();
                
        add(jpPakbon, BorderLayout.WEST); //Pakbonpanel toevoegen aan dit panel en het rechts van het scherm plaatsen
        add(jpXML, BorderLayout.EAST); //XML-panel toevoegen aan dit panel en het links van het scherm plaatsen
        
        
        
        
    }
    

}
