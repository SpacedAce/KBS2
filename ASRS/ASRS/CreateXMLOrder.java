/**
 * Charlene Hoogkamer
 * s1092106
 * ICTm2b
 */

package ASRS;

import javax.swing.*;

public class CreateXMLOrder extends JDialog{
    private JLabel jlOrdernr1;
    private JLabel jlOrdernr2;
    private JLabel jlKlant;
    private JLabel jlDatum1;
    private JLabel jlDatum2;
    private JLabel jlProducten;
    private JComboBox jcbKlant;
    private JComboBox jcbProducten;
    private JScrollBar jsbOverzicht;
    private JTextField jtfOverzicht;
    private JTable jtOverzicht;
    private JButton jbToevoegen;
    private JButton jbVerwijder;
    private JButton jbCreeer;   
    
    public CreateXMLOrder(JFrame frame) {
        super(frame, true);
        setSize(300, 300);
        setTitle("XML-editor");
        
        
        jlOrdernr1 = new JLabel("");
        add(jlOrdernr1);
        
        jlOrdernr2 = new JLabel("");
        add(jlOrdernr2);
        
        jlKlant = new JLabel("");
        add(jlKlant);
        
        jlDatum1 = new JLabel("");
        add(jlDatum1);
        
        jlDatum2 = new JLabel("");
        add(jlDatum2);
        
        jlProducten = new JLabel("");
        add(jlProducten);
        
        jcbKlant = new JComboBox();
        add(jcbKlant);
        
        jcbProducten = new JComboBox();
        add(jcbProducten);
        
        jsbOverzicht = new JScrollBar();
        add(jsbOverzicht);
        
        jtfOverzicht = new JTextField();
        add(jtfOverzicht);
        
        jtOverzicht = new JTable();
        add(jtOverzicht);
        
        jbToevoegen = new JButton("Toevoegen");
        add(jbToevoegen);
        
        jbVerwijder = new JButton("Verwijder");
        add(jbVerwijder);
        
        jbCreeer = new JButton("Creëer");
        add(jbCreeer);
        
        setVisible(true);
    
    }   
}
