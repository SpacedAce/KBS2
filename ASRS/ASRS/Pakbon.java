/**
 * Charlene Hoogkamer
 * s1092106
 * ICTm2b
 */

package ASRS;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class Pakbon extends JPanel implements ActionListener{
    private JLabel jlPakbon;
    private JTextArea jtaPakbon;
    private JScrollPane jspPakbon;
    private JButton jbSave;
    private JFileChooser jfcSave;
    private Status s;
    private Scherm scherm;
    
    public Pakbon(Scherm scherm) {
        this.scherm = scherm;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //Lay-out manager bepalen, BoxLayout gebruikt omdat dan alles makkelijk onder elkaar kan worden gezet (Y-AXIS)

        Color two = new Color(222, 232, 236);
        this.setBackground(two);

        jfcSave = new JFileChooser(); //Dit wordt gebruikt in de ActionListener, er wordt een window geopend waarme je een bestand kan openen of opslaan
        s = new Status();
         
        jlPakbon = new JLabel("Pakbon" /* + pakbonnaam en ordernummer */); //Label Pakbon toevoegen
        add(jlPakbon);


        jtaPakbon = new JTextArea(10, 30); //textArea voor de pakbon toevoegen
        add(jtaPakbon);
        jtaPakbon.setEditable(false); //Zorgen dat er niet in de textArea getypt kan worden
        
        jspPakbon = new JScrollPane(jtaPakbon); //Aanmaken van een scrollPane en de textArea hieraan toevoegen
        add(jspPakbon);

        jbSave = new JButton("Pakbon opslaan"); //Knop Opslaan toevoegen
        jbSave.setBackground(Color.WHITE);
        jbSave.setOpaque(true);
        add(jbSave);
        jbSave.addActionListener(this);

        jtaPakbon.setText("Selecteer een XML-bestand of een pakbon om deze hier weer te geven.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbSave) { //De knop Opslaan afhandelen/een functie geven
            int returnVal = jfcSave.showSaveDialog(Pakbon.this); //Code voor het openen van een window waarmee je een bestand kan opslaan
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = jfcSave.getSelectedFile();
                //This is where a real application would save the file.
                scherm.getStatus().jtaStatus.append("Opslaan: " + file.getName() + "\n");
            } else { //Als het opslaan niet lukt
                scherm.getStatus().jtaStatus.append("Opslaan geannuleerd\n");
            }
        }        
    }
}
