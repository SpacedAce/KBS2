package me.TSP;

import java.util.ArrayList;
import java.util.Collections;

public class WillekeurigAlgoritme extends Algoritme {

    public WillekeurigAlgoritme() {
        super.setName("Willekeurig Algoritme");
    }

    @Override
    public void calculate(ArrayList<Vak> locaties) {
        //START TIMER
        long startTime = System.nanoTime() / 1000;
        Vak zeroPoint = new Vak(0, 5);
        for(int i = 0; i < locaties.size(); i++) {
            getBestOrderLocaties().add(locaties.get(i));
        }
        //SHUFFLES getBestORderLocatie()
        Collections.shuffle(getBestOrderLocaties());
        //ADDS BEGIN AND END POINT
        getBestOrderLocaties().add(0, zeroPoint);
        getBestOrderLocaties().add(getBestOrderLocaties().size(), zeroPoint);
        float distance = 0;
        for(int a = 0; a < getBestOrderLocaties().size()-1; a++) {
            distance += Math.sqrt((getBestOrderLocaties().get(a).x - getBestOrderLocaties().get(a+1).x) * (getBestOrderLocaties().get(a).x - getBestOrderLocaties().get(a+1).x) +
            (getBestOrderLocaties().get(a).y - getBestOrderLocaties().get(a+1).y) * (getBestOrderLocaties().get(a).y - getBestOrderLocaties().get(a+1).y)
            );
        }
        //SETS DISTANCE
        setAftstand(distance);
        //END TIMER
        long totalTime = System.nanoTime() / 1000 - startTime;
        setTime(totalTime);
    }
}
