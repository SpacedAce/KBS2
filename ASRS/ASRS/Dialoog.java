package ASRS;

/**
 * Charlene Hoogkamer
 * s1092106
 * ICTm2b
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dialoog extends JDialog implements ActionListener{
    private JLabel jlOrdernr1;
    private JLabel jlOrdernr2;
    private JLabel jlKlant;
    private JLabel jlDatum1;
    private JLabel jlDatum2;
    private String datum;
    private JLabel jlProducten;
    private JComboBox<String> jcbKlant = new JComboBox<String>();
    private JComboBox<String> jcbProducten = new JComboBox<String>();
    private JScrollPane jsbOverzicht;
    private JTable jtOverzicht;
    private JButton jbToevoegen;
    private JButton jbVerwijder;
    private JButton jbMaak;
    private MyTableModel model;
    
    public Dialoog(JFrame scherm) {
        super(scherm, true);
        setSize(520, 580);
        setTitle("XML-editor");
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        setResizable(false);

        Color two = new Color(222, 232, 236);
        this.setBackground(two);

        String[] klanten = new String[] {"1. John Doe", "2. Jane Doe", "3. Jim Bar"};
        String[] producten = new String[] {"1. Stoel", "2. Tafel", "3. Bank"};

        jlOrdernr1 = new JLabel("Ordernummer: ");
        add(jlOrdernr1);
        
        jlOrdernr2 = new JLabel("1234567");
        add(jlOrdernr2);

        jlDatum1 = new JLabel("Datum: ");
        add(jlDatum1);

        datum = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        jlDatum2 = new JLabel(datum);
        add(jlDatum2);

        jlKlant = new JLabel("Klant: ");
        add(jlKlant);

        jcbKlant = new JComboBox(klanten);
        add(jcbKlant);

        jlProducten = new JLabel("Producten: ");
        add(jlProducten);
        
        jcbProducten = new JComboBox(producten);
        add(jcbProducten);

        model = new MyTableModel();
        model.addRow(new Object[]{"Stoel", 2 , false});
        model.addRow(new Object[]{"Tafel", 3, false});
        model.addRow(new Object[]{"Bank", 3, false});
        model.addRow(new Object[]{"Lamp", 1, false});
        jtOverzicht = new JTable(model);
        add(jtOverzicht);

        jsbOverzicht = new JScrollPane(jtOverzicht);
        add(jsbOverzicht);

        jbToevoegen = new JButton("Toevoegen");
        jbToevoegen.setBackground(Color.WHITE);
        jbToevoegen.setOpaque(true);
        add(jbToevoegen);
        
        jbVerwijder = new JButton("Verwijder");
        jbVerwijder.setBackground(Color.WHITE);
        jbVerwijder.setOpaque(true);
        add(jbVerwijder);
        
        jbMaak = new JButton("Maak");
        jbMaak.setBackground(Color.WHITE);
        jbMaak.setOpaque(true);
        add(jbMaak);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbToevoegen) {
            //WERKT NOG NIET --> model.addRow(new Object[]{jcbProducten.getSelectedItem().toString(), 1, false});
        }
        if(e.getSource() == jbVerwijder) {

        }
        if(e.getSource() == jbMaak) {

        }
    }
}