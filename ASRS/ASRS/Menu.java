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
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu extends JPanel implements ActionListener{
    private JButton jbSelectPakbon;
    private JButton jbSelectXML;
    private JButton jbGenerate;
    private JButton jbStart;
    private JTextField jtfXML;
    private JLabel jlXML;
    private JFileChooser jfcXML;
    private Status s = new Status();
    private Scherm scherm;
    private Dialoog dialoog;
    private XmlImport xmlimport;
    
    public Menu(Scherm scherm) {
        this.scherm = scherm;
        jfcXML = new JFileChooser(); //Dit wordt gebruikt in de ActionListener, er wordt een window geopend waarme je een bestand kan openen of opslaan
        setLayout(new GridBagLayout()); //Lay-out manager die werkt met posities(coördinaten)

        Color two = new Color(222, 232, 236);
        this.setBackground(two);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 20, 0, 20); //Hiermee zorg je ervoor dat elke button/label een padding heeft
             
        gbc.gridx = 0; //Dit is de x-coördinaat van de knop
        gbc.gridy = 0; //Dit is de y-coördinaat van de knop
        jbSelectPakbon = new JButton("Selecteer pakbon"); //Knop Selecteer Pakbon wordt aangemaakt
        jbSelectPakbon.setBackground(Color.WHITE);
        jbSelectPakbon.setOpaque(true);
        add(jbSelectPakbon, gbc); //Knop toevoegen aan het scherm en de padding toevoegen
        jbSelectPakbon.addActionListener(this); //Toevoegen van de ActionListener, zodat de knop iets gaat doen als er op geklikt wordt
        
        gbc.gridx = 0;
        gbc.gridy = 1;        
        jbSelectXML = new JButton("Selecteer XML"); //Knop Selecteer XML toevoegen
        jbSelectXML.setBackground(Color.WHITE);
        jbSelectXML.setOpaque(true);
        add(jbSelectXML, gbc);
        jbSelectXML.addActionListener(this);   
        
        gbc.gridx = 0;
        gbc.gridy = 2; 
        jlXML = new JLabel("Geselecteerde XML: "); //Label Geselecteerde XML: toevoegen
        add(jlXML, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        jtfXML = new JTextField(30); //Tekstveld waarin de bestandlocatie van het geselecteerde XML-bestand staat toevoegen
        add(jtfXML, gbc);
        jtfXML.setEditable(false); //Zorgen dat er niet in het tekstveld getypt kan worden
        
        gbc.gridx = 2;
        gbc.gridy = 0; 
        jbGenerate = new JButton("Genereer XML"); //Knop Genereer XML toevoegen
        jbGenerate.setBackground(Color.WHITE);
        jbGenerate.setOpaque(true);
        add(jbGenerate, gbc);
        jbGenerate.addActionListener(this);    
        
        gbc.gridx = 2;
        gbc.gridy = 1; 
        jbStart = new JButton("Start"); //Knop Start toevoegen
        jbStart.setBackground(Color.WHITE);
        jbStart.setOpaque(true);
        add(jbStart, gbc);
        jbStart.addActionListener(this);

        setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbSelectPakbon) { //De knop Selecteer Pakbon afhandelen/een functie geven
            int returnVal = jfcXML.showOpenDialog(Menu.this); //Code voor het openen van een window waarmee je een bestand kan openen
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = jfcXML.getSelectedFile();
                
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML-files", "xml");
                jfcXML.setFileFilter(filter); //Dit zorgt ervoor dat er alleen een bestand met de extensie .xml geselecteerd kan worden

                //This is where a real application would open the file.
                scherm.getStatus().jtaStatus.append("Openen: " + file.getName() + "\n"); //Printen in het statusscherm dat het bestand wordt geopend
            } else { //Als het opslaan niet lukt
                scherm.getStatus().jtaStatus.append("Openen geannuleerd\n"); //Printen in het statusscherm dat het openen van het bestand is geannulleerd
            }
        }
        
        if(e.getSource() == jbSelectXML) { //De knop Selecteer XML afhandelen een functie geven
            int returnVal = jfcXML.showOpenDialog(Menu.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) { //Code voor het openen van een window waarmee je een bestand kan openen

                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Pakbon en XML", "xml");
                    jfcXML.setFileFilter(filter); //Dit zorgt ervoor dat er alleen een bestand met de extensie .xml geselecteerd kan worden

                    File file = jfcXML.getSelectedFile();
                    String fileName = file.getAbsolutePath();
                    jtfXML.setText(fileName);

                    //This is where a real application would open the file.
                    scherm.getStatus().jtaStatus.append("Openen: " + file.getName() + "\n");
          
                } else { //Als het openen niet lukt     
                    scherm.getStatus().jtaStatus.append("Openen geannuleerd.\n");
                }
            }
        
        if(e.getSource() == jbGenerate) { //De knop Genereer XML afhandelen een functie geven
            //dialoog = new Dialoog(this);
            dialoog.setVisible(true);
            
               //Genereren van een XML dmv de generator en deze weergeven op het scherm
               
        }
        
        
        if(e.getSource() == jbStart) { //De knop Start afhandelen/een functie geven
               //Starten van het CreateXMLOrderproces
               
        }
    }
}