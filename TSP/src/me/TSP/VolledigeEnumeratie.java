package me.TSP;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kevin on 29-4-2016.
 */
public class VolledigeEnumeratie extends Algoritme {
    int counter = 0;
    ArrayList<Vak> best = new ArrayList<>();

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
           //for(int newLocIndex = 0; newLocIndex < )
       }
    }
}

