package me.TSP;

import java.util.ArrayList;

/**
 * Created by Kevin on 29-4-2016.
 */
public class TSP {
    private ArrayList<Algoritme> algoritme;
    private ArrayList<Vak> locaties;
    private ArrayList<Long> times;
    private ArrayList<Vak> allLocaties;

    public TSP(){
        algoritme = new ArrayList<>();
        locaties = new ArrayList<>();
        times = new ArrayList<>();
        allLocaties = new ArrayList<>();

        Hoofdscherm hoofdscherm = new Hoofdscherm(this);
    }

    public ArrayList<Algoritme> getAlgoritme(){
        return this.algoritme;
    }

    public ArrayList<Vak> getLocaties(){
        return this.locaties;
    }

    public void startSimulatie() {
        // Start simulation
    }

    public ArrayList<Long> getTimes(){
        return this.times;
    }

    public ArrayList<Vak> getAllLocaties(){
        return this.allLocaties;
    }
}


