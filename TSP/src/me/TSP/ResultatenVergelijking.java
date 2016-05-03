package me.TSP;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kevin on 29-4-2016.
 */
public class ResultatenVergelijking extends JDialog
{
    private JTable resultatenTable;
    private Object[] columnName = {"Simulatie Nummer","Algoritme", "Tijd", "Aantal Producten"};
    public ResultatenVergelijking(Object[][] data, JFrame frame)
    {
        super(frame,true);
        setSize(500,400);
        setLayout(new FlowLayout());
        resultatenTable = new JTable(data, columnName);
        JScrollPane scrollPane = new JScrollPane(resultatenTable);
        scrollPane.setVisible(true);
        resultatenTable.setFillsViewportHeight(true);
        resultatenTable.setPreferredScrollableViewportSize(new Dimension(480,400));
        add(scrollPane);
        int bestRow = 0;
        for(int i = 0; i < resultatenTable.getRowCount(); i++)
        {
            if((Long)resultatenTable.getValueAt(i,2) > (Long)resultatenTable.getValueAt(bestRow,2))
            {
                bestRow = i;
            }
        }
        resultatenTable.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer(bestRow));
        setVisible(true);
    }
}