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
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dialoog extends JDialog implements ActionListener {
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
    private JFileChooser jfcMaak;
    private PreparedStatement stmt = null;

    public Dialoog(JFrame frame) throws SQLException {
        super(frame, false);
        setSize(520, 580);
        setTitle("XML-editor");
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        setResizable(false);

        jfcMaak = new JFileChooser(); //Dit wordt gebruikt in de ActionListener, er wordt een window geopend waarme je een bestand kan openen of opslaan

        Color two = new Color(222, 232, 236);
        this.getContentPane().setBackground(two);

        ArrayList<String> artikelList = new ArrayList<>();

        try {
            Connection con = Database.getDBConnection();
            stmt = con.prepareStatement("SELECT naam, breedte FROM artikel");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String naam = rs.getString("Naam");
                String breedte = rs.getString("Breedte");
                String artikel = naam + ", " + breedte;
                artikelList.add(artikel);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        artikelList.toArray();

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

        jcbKlant = new JComboBox();
        add(jcbKlant);

        jlProducten = new JLabel("Producten: ");
        add(jlProducten);

        jcbProducten = new JComboBox();
        add(jcbProducten);

        model = new MyTableModel();
        for(String a: artikelList) {
            model.addRow(new Object[]{a});
        }
        jtOverzicht = new JTable(model);
        add(jtOverzicht);

        jsbOverzicht = new JScrollPane(jtOverzicht);
        add(jsbOverzicht);

        jbToevoegen = new JButton("Toevoegen");
        jbToevoegen.setBackground(Color.WHITE);
        jbToevoegen.setOpaque(true);
        add(jbToevoegen);
        jbToevoegen.addActionListener(this);

        jbVerwijder = new JButton("Verwijder");
        jbVerwijder.setBackground(Color.WHITE);
        jbVerwijder.setOpaque(true);
        add(jbVerwijder);
        jbVerwijder.addActionListener(this);

        jbMaak = new JButton("Maak");
        jbMaak.setBackground(Color.WHITE);
        jbMaak.setOpaque(true);
        add(jbMaak);
        jbMaak.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbToevoegen) {
            //WERKT NOG NIET --> model.addRow(new Object[]{jcbProducten.getSelectedItem().toString(), 1, false});
        }
        if (e.getSource() == jbVerwijder) {

        }
        if (e.getSource() == jbMaak) {

        }
    }
}
