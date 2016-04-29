package me.TSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Kevin on 29-4-2016.
 */
public class Hoofdscherm extends JFrame {
    private JTextField xInput;
    private JTextField yInput;
    private JButton addCoordinates;
    private JComboBox selectCoordinates;
    private JButton deleteCoordinates;
    private JComboBox selectAlgorithm;
    private JButton startSimulation;
    private JButton showResults;
    private TSP tsp;

    public Hoofdscherm(TSP tsp){
        this.tsp = tsp;
        setTitle("TSP-simulatie");
        setSize(new Dimension(800, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        JPanel panelLeft = new JPanel();

        add(new JLabel("X: "));
        add(xInput = new JTextField(10));
        setVisible(true);

        JPanel panelRight = new JPanel();
    }

    public void actionPerformed(ActionEvent e){

    }
}
