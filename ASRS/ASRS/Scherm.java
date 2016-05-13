/**
 * Charlene Hoogkamer
 * s1092106
 * ICTm2b
 */

package ASRS;

import java.awt.*;
import javax.swing.*;

public class Scherm extends JFrame {
    private Menu menuPanel;
    private Status statusPanel;
    private Pakbon pakbonPanel;
    private XML xmlPanel;
    
    public Scherm() {
        setTitle("AS/RS-Systeem");
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); //BorderLayout gebruiken om panels makkelijk te kunnen uitlijnen
        setResizable(false); //Zorgen dat het scherm van een vaste grootte is, om een lelijke lay-out te voorkomen
    
        menuPanel = new Menu(this); //Panel van klasse Menu toevoegen en deze bovenaan het scherm plaatsen
        add(menuPanel, BorderLayout.NORTH);        
        
        statusPanel = new Status(); //Panel van klasse Status toevoegen en deze in het midden van het scherm plaatsen
        add(statusPanel, BorderLayout.CENTER);

        xmlPanel = new XML();
        add(xmlPanel, BorderLayout.SOUTH);

        pakbonPanel = new Pakbon(this); //Panel van de klasse PakbonXML toevoegen en deze onderaan het scherm plaatsen
        add(pakbonPanel, BorderLayout.SOUTH);

        pack(); //Zorgt ervoor dat de grootte van het scherm precies de grootte van de drie panels samen is
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public Status getStatus() {
        return statusPanel;
    }
}
