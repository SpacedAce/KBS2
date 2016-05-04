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

    public SimulatiePanel(ArrayList<Vak> locaties)
    {
        this.locaties = locaties;
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
    }
}
