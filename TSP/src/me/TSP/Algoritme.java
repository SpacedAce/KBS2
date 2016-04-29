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
    private ArrayList<Vak> bestOderLocaties;

    public void calculate(ArrayList<Vak> locaties)
    {

    }

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

    public ArrayList<Vak> getBestOderLocaties() {
        return bestOderLocaties;
    }
}
