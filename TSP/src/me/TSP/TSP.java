package me.TSP;

import java.util.ArrayList;

public class TSP {
    private ArrayList<Algoritme> algoritme;
    private ArrayList<Vak> locaties;
    private ArrayList<Long> times;
    private ArrayList<Algoritme> allAlgoritme;

    public TSP(){
        algoritme = new ArrayList<>();
        locaties = new ArrayList<>();
        times = new ArrayList<>();
        allAlgoritme = new ArrayList<>();

        Hoofdscherm hoofdscherm = new Hoofdscherm(this);
    }

    public ArrayList<Algoritme> getAlgoritme(){
        return this.algoritme;
    }

    public ArrayList<Vak> getLocaties(){
        System.out.println(locaties);
        return this.locaties;
    }

    public void startSimulatie() {
        // Start simulation
    }

    public ArrayList<Long> getTimes(){
        return this.times;
    }

    public ArrayList<Algoritme> getAllAlgoritme(){
        return this.allAlgoritme;
    }
}


