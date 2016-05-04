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
        long startTime = System.nanoTime() / 1000;
        super.setBestOrderLocaties(locaties);
        Collections.shuffle(getBestOrderLocaties());
        ArrayList<Vak> tempZeroPoint = new ArrayList<>();
        for(int i = 0; i<locaties.size(); i++){
            tempZeroPoint
        }
        //END TIMER
        long totalTime = System.nanoTime() / 1000 - startTime;
        setTime(totalTime);
        System.out.println(super.getTime());
    }
}
