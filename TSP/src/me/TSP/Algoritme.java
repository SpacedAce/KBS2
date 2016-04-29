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

    public ArrayList<Vak> calculate(ArrayList<Vak> locaties)
    {
        return null;
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
}
