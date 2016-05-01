package me.TSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Kevin on 29-4-2016.
 */
public class Hoofdscherm extends JFrame implements ActionListener {

    //DEFINE SCREEN ELEMENTS

    private JTextField xInput;
    private JTextField yInput;
    private JButton addCoordinates;
    private JComboBox selectCoordinates;
    private JButton deleteCoordinates;
    private JComboBox selectAlgorithm;
    private JButton startSimulation;
    private JButton showResults;
    private TSP tsp;

    //CONSTRUCTOR, NEEDS TSP OBJECT. BECAUSE TSP OBJECT KEEPS APPLICATION DATA
    public Hoofdscherm(TSP tsp){
        this.tsp = tsp;

        //SETUP SCREEN
        setTitle("TSP-simulatie");
        setSize(new Dimension(800, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        //SETUP LEFT PANEL (LEFT SIDE OF THE SCREEN)
        JPanel panelLeft = new JPanel();
        add(panelLeft);
        panelLeft.setLayout(new FlowLayout());
        panelLeft.add(new JLabel("X: "));
        panelLeft.add(xInput = new JTextField(10));
        panelLeft.add(new JLabel("Y: "));
        panelLeft.add(yInput = new JTextField(10));
        panelLeft.add(addCoordinates = new JButton("Voeg toe"));
        addCoordinates.addActionListener(this);
        panelLeft.add(new JLabel("Kies een algoritme "));
        String[] algorithms = new String[]{"Kies algoritme", "Random", "Volledige enumeratie", "Ant colony", "Simpel gretig", "2-opt", "Simulated annealing"};
        panelLeft.add(selectAlgorithm = new JComboBox(algorithms));
        panelLeft.add(startSimulation = new JButton("Start simulatie"));
        startSimulation.addActionListener(this);

        //SETUP RIGHT PANEL (RIGHT SIDE OF THE SCREEN);
        JPanel panelRight = new JPanel();
        add(panelRight);
        panelRight.setLayout(new FlowLayout());
        panelRight.add(new JLabel("Coordinaten route: "));
        panelRight.add(selectCoordinates = new JComboBox(printCoor(tsp.getLocaties())));
        panelRight.add(deleteCoordinates = new JButton("Verwijder geselecteerde coordinaten"));
        deleteCoordinates.addActionListener(this);
        panelRight.add(showResults = new JButton("Bekijk resultaten"));
        showResults.addActionListener(this);

        setVisible(true);
    }

    //FUNCTION TO CONVERT THE ARRAYLIST WITH LOCATIONS IN A STRING ARRAY
    //FOR THE JCOMBOBOX.
    private String[] printCoor(ArrayList<Vak> a){
        String[] string = new String[a.size()];
        for (int i = 0; i<a.size(); i++){
            string[i] = a.get(i).toString();
        }
        return string;
    }

    public void actionPerformed(ActionEvent e){
        //WHEN BUTTON "BEKIJK RESULTATEN" WAS PRESSED
        if(e.getSource() == showResults){
            System.out.println("Show results");
            //WHEN BUTTON "VERWIJDER GESELECTEERDE COORDINATEN" WAS PRESSED
        } else if (e.getSource() == deleteCoordinates){
            int selectedIndex = selectCoordinates.getSelectedIndex();
            int size = selectCoordinates.getItemCount();
            try {
                for (int i = 0; i < size; i++) {
                    if (i == selectedIndex) {
                        tsp.getLocaties().remove(i);
                        selectCoordinates.removeAllItems();
                        for (int x = 0; x < tsp.getLocaties().size(); x++) {
                            selectCoordinates.addItem(tsp.getLocaties().get(x));
                        }
                    }
                }
            }catch(ArrayIndexOutOfBoundsException ai){
                System.out.println("Geen items meer");
            }
        } else if (e.getSource() == addCoordinates){
            try{
                int x = Integer.parseInt(xInput.getText());
                int y = Integer.parseInt(yInput.getText());
                Vak temp = new Vak(x, y);
                tsp.getLocaties().add(temp);
                selectCoordinates.addItem(temp);
                xInput.setBackground(Color.WHITE);
                yInput.setBackground(Color.WHITE);
            } catch(NumberFormatException nf) {
                xInput.setBackground(Color.RED);
                yInput.setBackground(Color.RED);
            }
        } else if (e.getSource() == startSimulation) {
            System.out.println("Start simulation");
        }
    }
}
