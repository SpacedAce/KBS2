package me.TSP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Resultaten extends JFrame implements ActionListener
{
    private JTable resultatenTable;
    private TSP tsp;
    private String[] columnName = {"Simulatie Nummer","Algoritme", "Tijd", "Aantal Producten", "vergelijk"};
    private JButton vergelijkButton;

    public Resultaten(TSP tsp)
    {
        this.tsp = tsp;
        setSize(650,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TSP Simulatie Resultaten");
        setLayout(new FlowLayout());

        //Test settings
        tsp.getAlgoritme().add(new WillekeurigAlgoritme());
        tsp.getAlgoritme().add(new VolledigeEnumeratie());
        tsp.getAlgoritme().get(0).setName("Willekeurig Algoritme");
        tsp.getAlgoritme().get(0).setSimulatieNr(0);
        tsp.getAlgoritme().get(0).setTime(new Long("0"));
        tsp.getAlgoritme().get(0).getBestOrderLocaties().add(new Vak(0,0,1));
        tsp.getAlgoritme().get(0).getBestOrderLocaties().add(new Vak(0,1,2));
        tsp.getAlgoritme().get(1).setName("Volledige Enumeratie");
        tsp.getAlgoritme().get(1).setSimulatieNr(1);
        tsp.getAlgoritme().get(1).setTime(new Long("2"));
        tsp.getAlgoritme().get(1).getBestOrderLocaties().add(new Vak(0,0,1));
        tsp.getAlgoritme().get(1).getBestOrderLocaties().add(new Vak(0,1,2));
        //End Settings

        //Data Object for JTable
        DefaultTableModel tabelModel = new DefaultTableModel(columnName,0);
        ArrayList<Algoritme> algoritmes = tsp.getAlgoritme();
        for(int i = 0; i < tsp.getAlgoritme().size(); i++)
        {
            Object[] objs = {algoritmes.get(i).getSimulatieNr(), algoritmes.get(i).getName(), algoritmes.get(i).getTime(), algoritmes.get(i).getBestOrderLocaties().size(), new Boolean(false)};
            tabelModel.addRow(objs);
        }

        //Setting objects
        vergelijkButton = new JButton("Vergelijk");
        resultatenTable = new JTable(tabelModel);

        //Setting column cell to return Boolean class
        TableColumn tc = resultatenTable.getColumnModel().getColumn(4);
        tc.setCellEditor(resultatenTable.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(resultatenTable.getDefaultRenderer(Boolean.class));

        //Adding to frame
        JScrollPane scrollPane = new JScrollPane(resultatenTable);
        scrollPane.setVisible(true);
        resultatenTable.setFillsViewportHeight(true);
        resultatenTable.setPreferredScrollableViewportSize(new Dimension(480,400));
        add(scrollPane);
        add(vergelijkButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vergelijkButton)
        {
            //Pressed Vergelijking
        }
    }
}
