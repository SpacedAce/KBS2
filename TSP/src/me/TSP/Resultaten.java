package me.TSP;

import javax.management.openmbean.OpenMBeanConstructorInfo;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
    private String[] columnName = {"Simulatie Nummer","Algoritme", "Tijd", "Afstand", "Aantal Producten", "vergelijk"};
    private JButton vergelijkButton;

    public Resultaten(TSP tsp)
    {
        this.tsp = tsp;
        setSize(650,500);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TSP Simulatie Resultaten");
        setLayout(new FlowLayout());

        //Data Object for JTable
        DefaultTableModel tabelModel = new DefaultTableModel(columnName,0);
        ArrayList<Algoritme> algoritmes = tsp.getAllAlgoritme();
        for(int i = 0; i < tsp.getAllAlgoritme().size(); i++)
        {
            Object[] objs = {algoritmes.get(i).getSimulatieNr(), algoritmes.get(i).getName(), algoritmes.get(i).getTime(), algoritmes.get(i).getBestOrderLocaties().size(), new Boolean(false)};
            tabelModel.addRow(objs);
        }

        //Setting objects
        vergelijkButton = new JButton("Vergelijk");
        vergelijkButton.addActionListener(this);
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
        int bestRow = 0;
        for(int i = 0; i < resultatenTable.getRowCount(); i++)
        {
            System.out.println((Long)resultatenTable.getValueAt(i,2));
            System.out.println((String)resultatenTable.getValueAt(i,1));
            System.out.println((Long)resultatenTable.getValueAt(bestRow,2));
            if((Long)resultatenTable.getValueAt(i,2) > (Long)resultatenTable.getValueAt(bestRow,2))
            {
                bestRow = i;
            }
        }
        resultatenTable.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer(bestRow));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vergelijkButton)
        {
            ArrayList<Object[]> array = new ArrayList<>();
            for(int i = 0; i < resultatenTable.getRowCount(); i++) {
                if((Boolean)resultatenTable.getValueAt(i,4))
                {
                    Object[] rowData = new Object[resultatenTable.getColumnCount()];
                    for(int x = 0; x < resultatenTable.getColumnCount(); x++)
                    {
                        if(x != 4) {
                            rowData[x] = resultatenTable.getValueAt(i, x);
                        }
                    }
                    array.add(rowData);
                }
            }
            Object[][] data = array.toArray(new Object[array.size()][]);
            if(data.length >= 2) {
                ResultatenVergelijking resultatenVergelijking = new ResultatenVergelijking(data, this);
            }
        }
    }
}

class CustomRenderer extends DefaultTableCellRenderer
{
    int bestRow;

    public CustomRenderer(int row)
    {
        this.bestRow = row;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(row == bestRow) {
            cellComponent.setBackground(Color.green);
        }
        else
        {
            cellComponent.setBackground(Color.WHITE);
        }
        return cellComponent;
    }
}
