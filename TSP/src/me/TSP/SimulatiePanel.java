package me.TSP;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kevin on 4-5-2016.
 */
public class SimulatiePanel extends JPanel
{
    private BufferedImage vakImg;
    private BufferedImage artikelImg;
    private JLabel timeLabel;
    private BufferedImage robotImg;
    private ArrayList<Vak> locaties;
    private Algoritme algoritme;
    private TSP tsp;

    public SimulatiePanel(ArrayList<Vak> locaties, Algoritme algoritme, TSP tsp)
    {
        setLayout(new BorderLayout());
        this.locaties = locaties;
        this.algoritme = algoritme;
        this.tsp = tsp;
        try
        {
            vakImg = ImageIO.read(new File("src/me/TSP/images/border.png"));
            artikelImg = ImageIO.read(new File("src/me/TSP/images/locatie.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        JPanel dataPanel = new JPanel();
        add(dataPanel, BorderLayout.SOUTH);
        dataPanel.setLayout(new GridLayout(5,1));
        dataPanel.add(new Label("Algoritme: " + algoritme.getName()));
        dataPanel.add(new Label("Ordernr: " + algoritme.getSimulatieNr()));
        dataPanel.add(new Label("Aantal producten: " + (algoritme.getBestOrderLocaties().size()-2)));
        dataPanel.add(new Label("Tijd: " + algoritme.getTime()));
        String s = String.format("%.2f", algoritme.getAftstand()*50);
        dataPanel.add(new Label("Afstand: " + s));
    }

    public void paintComponent(Graphics g)
    {
        for(int x = 1; x < 6; x++) {
            for(int y = 1; y < 6; y++) {
                if(y == 5)
                {
                    g.drawImage(vakImg,0, y*50-50,null);
                }
                for(int i = 0; i < algoritme.getBestOrderLocaties().size(); i++)
                {
                    if(algoritme.getBestOrderLocaties().get(i).x == x && algoritme.getBestOrderLocaties().get(i).y == y)
                    {
                        g.drawImage(artikelImg,x*50, y*50-50,null);
                        break;
                    }
                    else
                    {
                        g.drawImage(vakImg,x*50, y*50-50,null);
                    }
                }
            }
        }
        int lastIndex = 0;
        ArrayList<Vak> vaks = algoritme.getBestOrderLocaties();
        for(int v = 0; v < vaks.size(); v++)
        {
            if(v == vaks.size()) {
                g.drawString("" + v, vaks.get(v).x * 50 + 45, vaks.get(v).y * 50 - 38);
            }
            else if(v == 0)
            {
                g.drawString("" + v, vaks.get(v).x * 50 + 5, vaks.get(v).y * 50 - 38);
            }
            else {
                g.drawString("" + v, vaks.get(v).x * 50 + 20, vaks.get(v).y * 50 - 38);
            }
        }

        for(int l = 0;l < vaks.size(); l++)
        {
            if(lastIndex < vaks.size()-1)
            {
                g.setColor(Color.red);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g2.drawLine(vaks.get(lastIndex).x * 50 + 25, vaks.get(lastIndex).y * 50 - 25, vaks.get(lastIndex + 1).x * 50 + 25, vaks.get(lastIndex + 1).y * 50 - 25);
                lastIndex++;
            }
        }
    }
}
