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

    public SimulatiePanel(ArrayList<Vak> locaties, Algoritme algoritme)
    {
        this.locaties = locaties;
        this.algoritme = algoritme;
        try
        {
            vakImg = ImageIO.read(new File("border.png"));
            artikelImg = ImageIO.read(new File("locatie.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g)
    {
        for(int x = 0; x < 5; x++) {
            for(int y = 0; y < 5; y++) {
                for(int i = 0; i < locaties.size(); i++)
                {
                    if(locaties.get(i).x == x && locaties.get(i).y == y)
                    {
                        g.drawImage(artikelImg,x*50, y*50,null);
                        break;
                    }
                    else
                    {
                        g.drawImage(vakImg,x*50, y*50,null);
                    }
                }
            }
        }
        int lastIndex = 0;
        ArrayList<Vak> vaks = algoritme.getBestOrderLocaties();
        for(int v = 0; v < vaks.size(); v++)
        {
            g.drawString("" + v,vaks.get(v).x * 50 + 20,vaks.get(v).y * 50 + 12);
        }

        for(int l = 0;l < vaks.size(); l++)
        {
            if(lastIndex < vaks.size()-1)
            {
                g.setColor(Color.red);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g2.drawLine(vaks.get(lastIndex).x * 50 + 25, vaks.get(lastIndex).y * 50 + 25, vaks.get(lastIndex + 1).x * 50 + 25, vaks.get(lastIndex + 1).y * 50 + 25);
                lastIndex++;
            }
        }
    }
}
