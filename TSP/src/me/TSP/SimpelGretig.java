package me.TSP;

import java.util.ArrayList;
import java.util.Collections;

public class SimpelGretig extends Algoritme {

    public SimpelGretig() {
        super.setName("Simpel Gretig");
    }

    @Override
    public void calculate(ArrayList<Vak> locaties) {
        //STARTS TIMER

        long startTime = System.nanoTime() / 1000;
        ArrayList<Vak> currentSolution = new ArrayList<>();
        currentSolution.addAll(locaties);

        //INITIAlIZE BEGIN AND END POINT
        Vak zeroPoint = new Vak(0, 5);

        //INITIALIZE NEW ARRAYLIST FOR BEST SOLUTION OF THIS ALGORITHM
        ArrayList<Vak> newSolution = new ArrayList<>();
        currentSolution.add(0,zeroPoint);
        newSolution.add(0,zeroPoint);

        //CHECKS FOR CLOSEST NEIGHBOR
        while(currentSolution.size() > 1) {
            int bestIndex = 1;
            for (int i = 2; i < currentSolution.size(); i++)
            {
                double currentDistance = Math.sqrt((currentSolution.get(0).x - currentSolution.get(i).x) * (currentSolution.get(0).x - currentSolution.get(i).x) +
                        (currentSolution.get(0).y - currentSolution.get(i).y) * (currentSolution.get(0).y - currentSolution.get(i).y)
                );;
                double currentBestDistance = Math.sqrt((currentSolution.get(0).x - currentSolution.get(bestIndex).x) * (currentSolution.get(0).x - currentSolution.get(bestIndex).x) +
                        (currentSolution.get(0).y - currentSolution.get(bestIndex).y) * (currentSolution.get(0).y - currentSolution.get(bestIndex).y)
                );;
                if(currentDistance < currentBestDistance)
                {
                    bestIndex = i;
                }
            }
            //ADDS CLOSEST NEIGHBOR TO BEST SOLUTION ARRAYLIST, AND DELETES IT FROM THE CURRENT SOLUTION ARRAYLIST
            newSolution.add(currentSolution.get(bestIndex));
            Vak newStartPoint = currentSolution.get(bestIndex);
            currentSolution.remove(bestIndex);
            currentSolution.remove(0);
            currentSolution.add(0, newStartPoint);
        }
        newSolution.add(zeroPoint);
        getBestOrderLocaties().addAll(newSolution);
        float distance = 0;

        //CALCULATES TOTAL DISTANCE
        for(int bestIndex = 0; bestIndex < newSolution.size()-1; bestIndex++)
        {
            distance += Math.sqrt((newSolution.get(bestIndex).x - newSolution.get(bestIndex+1).x) * (newSolution.get(bestIndex).x - newSolution.get(bestIndex+1).x) +
                    (newSolution.get(bestIndex).y - newSolution.get(bestIndex+1).y) * (newSolution.get(bestIndex).y - newSolution.get(bestIndex+1).y)
            );
        }
        setAftstand(distance);
    }
}

