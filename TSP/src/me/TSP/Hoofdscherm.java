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
    private JCheckBox randomAlgoritme;
    private JCheckBox volledigAlgoritme;
    private JCheckBox simpelGretigAlgoritme;
    private JCheckBox twoOptAlgoritme;
    private JCheckBox simulatedAnnealingAlgoritme;

    private JButton startSimulation;
    private JButton showResults;
    private TSP tsp;

    //CONSTRUCTOR, NEEDS TSP OBJECT. BECAUSE TSP OBJECT KEEPS APPLICATION DATA
    public Hoofdscherm(TSP tsp) {
        this.tsp = tsp;

        //SETUP SCREEN
        setTitle("TSP-simulatie");
        setSize(new Dimension(750, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(1, 2));

        //SETUP LEFT PANEL (LEFT SIDE OF THE SCREEN)
        JPanel panelLeft = new JPanel();
        add(panelLeft);
        panelLeft.setLayout(new BorderLayout());
        JPanel panelLeftTop = new JPanel();
        panelLeft.add(panelLeftTop, BorderLayout.CENTER);
        panelLeftTop.setLayout(new FlowLayout());
        panelLeftTop.add(new JLabel("X: "));
        panelLeftTop.add(xInput = new JTextField(10));
        panelLeftTop.add(new JLabel("Y: "));
        panelLeftTop.add(yInput = new JTextField(10));
        panelLeftTop.add(addCoordinates = new JButton("Voeg toe"));
        addCoordinates.addActionListener(this);
        panelLeftTop.add(new JLabel("Kies een algoritme: "));

        //INITIALIZATION CHECKBOXES AND CORRESPONDING JPANEL WITH GRIDLAYOUT
        JPanel checkBoxes = new JPanel();
        checkBoxes.setLayout(new GridLayout(5, 1));
        panelLeftTop.add(checkBoxes);

        randomAlgoritme = new JCheckBox("Random");
        randomAlgoritme.setSelected(false);
        checkBoxes.add(randomAlgoritme);
        volledigAlgoritme = new JCheckBox("Volledige enumeratie");
        volledigAlgoritme.setSelected(false);
        checkBoxes.add(volledigAlgoritme);
        simpelGretigAlgoritme = new JCheckBox("Simpel gretig");
        simpelGretigAlgoritme.setSelected(false);
        checkBoxes.add(simpelGretigAlgoritme);
        twoOptAlgoritme = new JCheckBox("2-opt");
        twoOptAlgoritme.setSelected(false);
        checkBoxes.add(twoOptAlgoritme);
        simulatedAnnealingAlgoritme = new JCheckBox("Simulated annealing");
        simulatedAnnealingAlgoritme.setSelected(false);
        checkBoxes.add(simulatedAnnealingAlgoritme);

        //CREATES START SIMULATION BUTTON
        JPanel panelLeftBottom = new JPanel();
        panelLeftBottom.setPreferredSize(new Dimension(375, 75));
        panelLeft.add(panelLeftBottom, BorderLayout.SOUTH);
        panelLeftBottom.add(startSimulation = new JButton("Start simulatie"));
        startSimulation.addActionListener(this);

        //SETUP RIGHT PANEL (RIGHT SIDE OF THE SCREEN);
        JPanel panelRight = new JPanel();
        add(panelRight);
        panelRight.setLayout(new BorderLayout());

        JPanel panelRightTop = new JPanel();
        panelRight.add(panelRightTop, BorderLayout.CENTER);
        panelRightTop.setLayout(new FlowLayout());
        panelRightTop.add(new JLabel("Coordinaten route: "));
        panelRightTop.add(selectCoordinates = new JComboBox(printCoor(tsp.getLocaties())));
        panelRightTop.add(deleteCoordinates = new JButton("Verwijder geselecteerde coordinaten"));
        deleteCoordinates.addActionListener(this);

        JPanel panelRightBottom = new JPanel();
        panelRight.add(panelRightBottom, BorderLayout.SOUTH);
        panelRightBottom.setPreferredSize(new Dimension(375, 75));
        JPanel panelRightBottomLeft = new JPanel();
        panelRightBottom.add(panelRightBottomLeft);
        panelRightBottomLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelRightBottomLeft.add(showResults = new JButton("Bekijk resultaten"));
        showResults.addActionListener(this);

        setVisible(true);
    }

    //FUNCTION TO CONVERT THE ARRAYLIST WITH LOCATIONS IN A STRING ARRAY
    //FOR THE JCOMBOBOX.
    private String[] printCoor(ArrayList<Vak> a) {
        String[] string = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            string[i] = a.get(i).toString();
        }
        return string;
    }

    //CREATES A SIMULATION NUMBER
    private int createSimulationNumber(){
        int simulationNr;
        if(tsp.getAllAlgoritme().isEmpty()){
            simulationNr = 1;
        } else {
            simulationNr = tsp.getAllAlgoritme().get(tsp.getAllAlgoritme().size()-1).getSimulatieNr();
        }
        return simulationNr;
    }
    //CHECKBOX BOOLEAN CHECK AND CREATION OF ALGORITHMS
    private void checkAlgoritme() {
        int simulationNr = createSimulationNumber();

        if (randomAlgoritme.isSelected()) {
            Algoritme willekeurigAlgoritme = new WillekeurigAlgoritme();
            tsp.getAlgoritme().add(willekeurigAlgoritme);
            willekeurigAlgoritme.setSimulatieNr(simulationNr);
        }
        if (volledigAlgoritme.isSelected()) {
            Algoritme volledigeEnumeratie = new VolledigeEnumeratie();
            tsp.getAlgoritme().add(volledigeEnumeratie);
            volledigeEnumeratie.setSimulatieNr(simulationNr);
        }
        if (simpelGretigAlgoritme.isSelected()) {
            Algoritme simpelGretig = new SimpelGretig();
            tsp.getAlgoritme().add(simpelGretig);
            simpelGretig.setSimulatieNr(simulationNr);
        }
        if (twoOptAlgoritme.isSelected()) {
            Algoritme twoOptAlgoritme = new TwoOptAlgoritme();
            tsp.getAlgoritme().add(twoOptAlgoritme);
            twoOptAlgoritme.setSimulatieNr(simulationNr);
        }
        if (simulatedAnnealingAlgoritme.isSelected()) {
            Algoritme simulatedAnnealing = new SimulatedAnnealing();
            tsp.getAlgoritme().add(simulatedAnnealing);
            simulatedAnnealing.setSimulatieNr(simulationNr);
        }
    }

    public void actionPerformed(ActionEvent e) {
        //WHEN BUTTON "BEKIJK RESULTATEN" WAS PRESSED
        if (e.getSource() == showResults) {
            System.out.println("Show results");
            Resultaten resultaten = new Resultaten(tsp);
           /* for (int i = 0; i < tsp.getLocaties().size(); i++) {
                System.out.println(tsp.getLocaties().get(i));
            }*/
            //WHEN BUTTON "VERWIJDER GESELECTEERDE COORDINATEN" WAS PRESSED
        } else if (e.getSource() == deleteCoordinates) {
            //CHECK SIZE AND SELECTED ITEM FROM JCOMBOBOX
            int selectedIndex = selectCoordinates.getSelectedIndex();
            int size = selectCoordinates.getItemCount();
            try {
                for (int i = 0; i < size; i++) {
                    if (i == selectedIndex) {
                        //DELETE VAK FROM ARRAYLIST AND REFRESH JCOMBOBOX
                        tsp.getLocaties().remove(i);
                        selectCoordinates.removeAllItems();
                        for (int x = 0; x < tsp.getLocaties().size(); x++) {
                            selectCoordinates.addItem(tsp.getLocaties().get(x));
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ai) {
                System.out.println("Geen items meer");
            }
            //WHEN BUTTON "VOEG TOE" WAS PRESSED
        } else if (e.getSource() == addCoordinates) {
            try {
                int x = Integer.parseInt(xInput.getText());
                int y = Integer.parseInt(yInput.getText());
                Vak temp = new Vak(x, y);
                tsp.getLocaties().add(temp);
                selectCoordinates.addItem(temp);
                xInput.setBackground(Color.WHITE);
                yInput.setBackground(Color.WHITE);
            } catch (NumberFormatException nf) {
                xInput.setBackground(Color.RED);
                yInput.setBackground(Color.RED);
            }
            //WHEN BUTTON "START SIMULATIE" WAS PRESSED
        } else if (e.getSource() == startSimulation) {
            checkAlgoritme();
            for(int i = 0; i<tsp.getAlgoritme().size(); i++){
                tsp.getAlgoritme().get(i).calculate(tsp.getLocaties());
                tsp.getAllAlgoritme().add(tsp.getAlgoritme().get(i));
                tsp.getAlgoritme().remove(i);
            }
            Simulatie simulatie = new Simulatie(tsp.getLocaties(), createSimulationNumber(),tsp);
        }
    }
}
