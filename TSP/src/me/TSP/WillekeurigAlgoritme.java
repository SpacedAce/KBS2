package me.TSP;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kevin on 29-4-2016.
 */
public class WillekeurigAlgoritme extends Algoritme {

    public WillekeurigAlgoritme() {
        super.setName("Willekeurig Algoritme");
    }

    @Override
    public void calculate(ArrayList<Vak> locaties) {
        //START TIMER
        long startTime = System.currentTimeMillis();
        setBestOrderLocaties(locaties);
        Collections.shuffle(getBestOrderLocaties());

        for(int i = 0; i<locaties.size(); i++){
            System.out.println(locaties.get(i));
        }

        //END TIMER
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        setTime(totalTime);
    }
}
