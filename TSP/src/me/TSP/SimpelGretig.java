package me.TSP;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kevin on 29-4-2016.
 */
public class SimpelGretig extends Algoritme {

    private Vak zeroPoint;
    private ArrayList<Vak> tempLocaties;
    private ArrayList<Vak> nieuweVolgorde;
    private ArrayList<Vak> locaties;
    private Vak dichtstbijzijnde;
    private double dichtstAfstand;

    public SimpelGretig() {
        super.setName("Simpel Gretig");
        zeroPoint = new Vak(0, 5, 99);
        tempLocaties = new ArrayList<>();
        nieuweVolgorde = new ArrayList<>();
        dichtstAfstand = 999999999;
    }

    public void calculate(ArrayList<Vak> locaties) {
        //START TIMER
        long startTime = System.nanoTime() / 1000;
        this.locaties = locaties;
        tempLocaties.addAll(locaties);
        nieuweVolgorde.add(0, zeroPoint);

        for (int i = 0; i < locaties.size(); i++) {
            while (tempLocaties.size() > 0) {
                for (int k = 1; k < tempLocaties.size() + 1; k++) {
                    int tempX1 = tempLocaties.get(i).x;
                    int tempY1 = tempLocaties.get(i).y;
                    if (k != tempLocaties.size()) {
                        int tempX2 = tempLocaties.get(k).x;
                        int tempY2 = tempLocaties.get(k).y;
                        double tempSingleAfstand = Math.sqrt(Math.pow(tempX2 - tempX1, 2) + Math.pow(tempY2 - tempY1, 2));
                        if (tempSingleAfstand < dichtstAfstand) {
                            tempSingleAfstand = dichtstAfstand;
                            dichtstbijzijnde = locaties.get(k);
                        }
                    }
                }
                nieuweVolgorde.add(dichtstbijzijnde);
                dichtstAfstand = 99999999;
                tempLocaties.remove(i);
            }
        }
        nieuweVolgorde.add(nieuweVolgorde.size(), zeroPoint);
        //getBestOrderLocaties().addAll(nieuweVolgorde);
        for (int c = 0; c < nieuweVolgorde.size(); c++) {
            System.out.println(nieuweVolgorde.get(c));
        }

        //END TIMER
        long totalTime = System.nanoTime() / 1000 - startTime;

        setTime(totalTime);
    }
}

