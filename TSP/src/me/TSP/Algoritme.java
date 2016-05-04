package me.TSP;

import java.util.ArrayList;

/**
 * Created by Kevin on 29-4-2016.
 */
public abstract class Algoritme
{
    private Long time;
    private String name;
    private int simulatieNr;
    private float aftstand;
    private ArrayList<Vak> bestOrderLocaties = new ArrayList<>();

    public void calculate(ArrayList<Vak> locaties) {}

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSimulatieNr() {
        return simulatieNr;
    }

    public void setSimulatieNr(int simulatieNr) {
        this.simulatieNr = simulatieNr;
    }

    public ArrayList<Vak> getBestOrderLocaties() {
        return this.bestOrderLocaties;
    }
    public void setBestOrderLocaties(ArrayList<Vak> a){
        this.bestOrderLocaties = a;
    }

    public float getAftstand() {
        return aftstand;
    }

    public void setAftstand(float aftstand) {
        this.aftstand = aftstand;
    }
}
