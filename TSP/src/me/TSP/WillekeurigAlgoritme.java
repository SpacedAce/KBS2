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
        ArrayList<Vak> tempZeroPoint = new ArrayList<>();
        tempZeroPoint.add(locaties.get(0));
        tempZeroPoint.add(locaties.get(locaties.size()-1));
        locaties.remove(0);
        locaties.remove(locaties.size()-1);
        super.setBestOrderLocaties(locaties);
        Collections.shuffle(getBestOrderLocaties());
        getBestOrderLocaties().add(0, tempZeroPoint.get(0));
        getBestOrderLocaties().add(locaties.size(), tempZeroPoint.get(1));
        //END TIMER
        long totalTime = System.nanoTime() / 1000 - startTime;
        setTime(totalTime);
        System.out.println(super.getTime());
    }
}
