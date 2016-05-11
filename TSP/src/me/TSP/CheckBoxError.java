package me.TSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxError extends JDialog implements ActionListener{
    private JButton sluiten;
    private JTextArea warning;

    public CheckBoxError(JFrame frame){
        super(frame, true);
        setSize(new Dimension(250, 125));
        setLayout(new FlowLayout());
        setResizable(false);

        warning = new JTextArea("Er is geen algoritme geselecteerd. \nSelecteer een algoritme om door te gaan.");
        warning.setOpaque(false);
        warning.setEditable(false);
        warning.setFocusable(false);
        add(warning);

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
