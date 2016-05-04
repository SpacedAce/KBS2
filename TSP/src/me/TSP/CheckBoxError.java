package me.TSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jeroen on 4-5-2016.
 */
public class CheckBoxError extends JDialog implements ActionListener{
    private JButton sluiten;
    private JTextArea waarschuwing;

    public CheckBoxError(JFrame frame){
        super(frame, true);
        setSize(new Dimension(250, 125));
        setLayout(new FlowLayout());
        setResizable(false);

        waarschuwing = new JTextArea("Er is geen algoritme geselecteerd. \nSelecteer een algoritme om door te gaan.");
        waarschuwing.setOpaque(false);
        waarschuwing.setEditable(false);
        waarschuwing.setFocusable(false);
        add(waarschuwing);

        sluiten = new JButton("Sluiten");
        add(sluiten);
        sluiten.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sluiten){
            setVisible(false);
        }
    }
}
