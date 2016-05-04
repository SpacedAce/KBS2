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
        Vak zeroPoint = new Vak(0, 5, 99);
        for(int i = 0; i < locaties.size(); i++)
        {
            getBestOrderLocaties().add(locaties.get(i));
        }
        Collections.shuffle(getBestOrderLocaties());
        getBestOrderLocaties().add(0, zeroPoint);
        getBestOrderLocaties().add(getBestOrderLocaties().size(), zeroPoint);
        //END TIMER
        long totalTime = System.nanoTime() / 1000 - startTime;
        setTime(totalTime);
    }
}
