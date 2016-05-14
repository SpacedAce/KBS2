/**
 * Charlene Hoogkamer
 * s1092106
 * ICTm2b
 */

package ASRS;

import java.awt.*;
import javax.swing.*;

public class Status extends JPanel {
    public JTextArea jtaStatus;
    public JScrollPane jpaStatus;
    private String test;
    
    public Status() {
        setLayout(new BorderLayout()); //Lay-out mananger kiezen

        Color two = new Color(222, 232, 236);
        this.setBackground(two);
        
        jtaStatus = new JTextArea(5, 10); //Status textArea toevoegen
        add(jtaStatus);
        jtaStatus.setEditable(false); //Zorgen dat er niet in de textArea getypt kan worden
        
        jpaStatus = new JScrollPane(jtaStatus); //Aanmaken van een scrollPane en de textArea hieraan toevoegen
        add(jpaStatus);
    }

    public String getTest() {

        return test;
    }
}

