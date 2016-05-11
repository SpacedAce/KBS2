package me.TSP;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class VolledigeEnumeratie extends Algoritme {

    ArrayList<Vak> best = new ArrayList<>();

    public VolledigeEnumeratie() {
        super.setName("Volledige Enumeratie");
    }

    @Override
    //CALCULATE ALGORITHM: ROUTE, TIME AND DISTANCE
    public void calculate(ArrayList<Vak> locaties) {
        long startTime = System.nanoTime() / 1000;
        Vak zeropoint = new Vak(0,5);
        locaties.add(0,zeropoint);
        locaties.add(zeropoint);
        iteration(locaties,1);
        getBestOrderLocaties().addAll(best);
        float distance = (float)calculateDistance(best);
        setAftstand(distance);
        long totalTime = System.nanoTime() / 1000 - startTime;
        setTime(totalTime);
    }
    //FUNCTION WHICH SWAPS ARRAYLIST FOR EVERY POSSIBLE COMBINATION ARRAYLIST
    public void iteration(ArrayList<Vak> loc, int t) {
       if(t < loc.size()-1)
       {
           for(int i = t; i < loc.size()-1; ++i)
           {
               Collections.swap(loc,t,i);
               iteration(loc, t+1);
               Collections.swap(loc,t,i);
           }
       } else {
           //System.out.println(loc);
           if(best.size() != 0) {
               double bestDistance = calculateDistance(best);
               double currentDistance = calculateDistance(loc);
               if(currentDistance < bestDistance)
               {
                   best.clear();
                   best.addAll(loc);
               }
           } else {
               best.addAll(loc);
           }
       }
    }
    //THIS FUNCTIONS CALCULATES DISTANCE BETWEEN VAK ELEMENTS IN INCOMING ARRAYLIST
    private double calculateDistance(ArrayList<Vak> a){
        double sumDistance = 0;
        for(int i = 0; i < a.size()-1; i++){
            sumDistance += Math.sqrt(Math.pow((a.get(i).x) - (a.get(i + 1).x), 2) + Math.pow((a.get(i).x) - (a.get(i + 1).x), 2));
        }
        return sumDistance;
    }
}


