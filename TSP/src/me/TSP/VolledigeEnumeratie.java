package me.TSP;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kevin on 29-4-2016.
 */
public class VolledigeEnumeratie extends Algoritme {
    int counter = 0;
    ArrayList<ArrayList<Vak>> best = new ArrayList<>();

    public VolledigeEnumeratie() {
        super.setName("Volledige Enumeratie");
    }

    @Override
    public void calculate(ArrayList<Vak> locaties)
    {
        iteration(locaties,0);
    }

    public void iteration(ArrayList<Vak> loc, int t)
    {
       if(t < loc.size())
       {
           for(int i = t; i < loc.size(); ++i)
           {
               Collections.swap(loc,t,i);
               iteration(loc, t+1);
               Collections.swap(loc,t,i);
           }
       }
       else
       {
           System.out.println(loc);
           best.add(loc);
           //for(int newLocIndex = 0; newLocIndex < )
           for(int i = 0; i<loc.size(); i++){
                
           }
       }
    }
    private double calculateDistance(ArrayList<Vak> a){
        double sumDistance = 0;
        for(int i = 0; i<a.size(); i++){
            if(i!= a.size()-1) {
                sumDistance += Math.sqrt(Math.pow((a.get(i).x) - (a.get(i + 1).x), 2) + Math.pow((a.get(i).x) - (a.get(i + 1).x), 2));
            } else {
                System.out.println("Done");
            }
        }
        return sumDistance;
    }
}


