package me.TSP;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Kevin on 29-4-2016.
 */
public class Simulatie extends JFrame
{
    public Simulatie(ArrayList<Vak> locaties, int simulatieNr, TSP tsp)
    {
        setSize(500,500);
        setTitle("Simulatie");
        setLayout(new FlowLayout());
        setVisible(true);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(450,450));
        add(tabbedPane);
        for(int i = 0; i < tsp.getAllAlgoritme().size(); i++)
        {
            if(tsp.getAllAlgoritme().get(i).getSimulatieNr() == simulatieNr)
            {
                SimulatiePanel simulatiePanel = new SimulatiePanel(locaties, tsp.getAllAlgoritme().get(i), tsp);
                String split[] = tsp.getAllAlgoritme().get(i).getName().split(" ",2);
                tabbedPane.addTab(split[0], simulatiePanel);
            }
        }
    }
}
