package ASRS;

/**
 * Charlene Hoogkamer
 * s1092106
 * ICTm2b
 */

import javax.swing.*;
import java.awt.*;

public class Dialoog extends JFrame{
    private JLabel jlOrdernr1;
    private JLabel jlOrdernr2;
    private JLabel jlKlant;
    private JLabel jlDatum1;
    private JLabel jlDatum2;
    private JLabel jlProducten;
    private JComboBox<String> jcbKlant = new JComboBox<String>();
    private JComboBox<String> jcbProducten = new JComboBox<String>();
    private JScrollPane jsbOverzicht;
    private JTextField jtfOverzicht;
    private JTable jtOverzicht;
    private JButton jbToevoegen;
    private JButton jbVerwijder;
    private JButton jbMaak;   
    
    public Dialoog() {
        setSize(400, 400);
        setTitle("XML-editor");
        setLayout(new FlowLayout());

        String[] klanten = new String[] {"1. John Doe", "2. Jane Doe", "3. Jim Bar"};
        String[] producten = new String[] {"1. Stoel", "2. Tafel", "3. Bank"};
        
        jlOrdernr1 = new JLabel("Ordernummer: ");
        add(jlOrdernr1);
        
        jlOrdernr2 = new JLabel("1234567");
        add(jlOrdernr2);

        jlDatum1 = new JLabel("Datum: ");
        add(jlDatum1);
        
        jlDatum2 = new JLabel("DD-MM-YYYY");
        add(jlDatum2);

        jlKlant = new JLabel("Klant: ");
        add(jlKlant);

        jcbKlant = new JComboBox(klanten);
        add(jcbKlant);

        jlProducten = new JLabel("Producten: ");
        add(jlProducten);
        
        jcbProducten = new JComboBox(producten);
        add(jcbProducten);

        Object tabelData[][] = {{"Stoel", "2", "/"}, {"Tafel", "1", "/"}, {"Bank", 2, "/"}};
        Object tabelNaam[] = {"Naam", "Aantal", "Verwijder"};
        jtOverzicht = new JTable(tabelData, tabelNaam);
        add(jtOverzicht);

        jsbOverzicht = new JScrollPane(jtOverzicht);
        add(jsbOverzicht);

        jbToevoegen = new JButton("Toevoegen");
        add(jbToevoegen);
        
        jbVerwijder = new JButton("Verwijder");
        add(jbVerwijder);
        
        jbMaak = new JButton("Maak");
        add(jbMaak);
        
        setVisible(true);
    
    }
}