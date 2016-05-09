package me.TSP;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kevin on 29-4-2016.
 */
public class SimulatedAnnealing extends Algoritme
{
    public SimulatedAnnealing()
    {
        super.setName("Simulated Annealing");
    }

    @Override
    public void calculate(ArrayList<Vak> locaties) {
        long startTime = System.nanoTime() / 1000;
        double startTemp = 10000;
        double cooling = 0.003;

        ArrayList<Vak> startOplossing = new ArrayList<>();
        startOplossing.addAll(locaties);
        Collections.shuffle(startOplossing);
        Vak zeroPoint = new Vak(0, 5, 99);
        startOplossing.add(0, zeroPoint);
        startOplossing.add(startOplossing.size(), zeroPoint);
        ArrayList<Vak> best = new ArrayList<>();
        best.addAll(startOplossing);

        while(startTemp > 1)
        {
            ArrayList<Vak> newOplossing = new ArrayList<>();
            newOplossing.addAll(startOplossing);
            int randomIndex1 = (int)(newOplossing.size()-1 * Math.random());
            int randomIndex2 = (int)(newOplossing.size()-1 * Math.random());
            if(randomIndex1 == 0 || randomIndex2 == 0)
            {
                continue;
            }
            Collections.swap(newOplossing, randomIndex1, randomIndex2);

            float currentDistance = 0;
            for(int currentIndex = 0; currentIndex < startOplossing.size()-1; currentIndex++)
            {
                currentDistance += Math.sqrt((startOplossing.get(currentIndex).x - startOplossing.get(currentIndex+1).x) * (startOplossing.get(currentIndex).x - startOplossing.get(currentIndex+1).x) +
                        (startOplossing.get(currentIndex).y - startOplossing.get(currentIndex+1).y) * (startOplossing.get(currentIndex).y - startOplossing.get(currentIndex+1).y)
                );
            }

            float newDistance = 0;
            for(int newIndex = 0; newIndex < newOplossing.size()-1; newIndex++)
            {
                newDistance += Math.sqrt((newOplossing.get(newIndex).x - newOplossing.get(newIndex+1).x) * (newOplossing.get(newIndex).x - newOplossing.get(newIndex+1).x) +
                        (newOplossing.get(newIndex).y - newOplossing.get(newIndex+1).y) * (newOplossing.get(newIndex).y - newOplossing.get(newIndex+1).y)
                );
            }

            if(acceptanceProbability(currentDistance, newDistance, startTemp) > Math.random())
            {
                startOplossing.clear();
                startOplossing.addAll(newOplossing);
            }

            float currentDistanceCheck = 0;
            for(int currentIndex = 0; currentIndex < startOplossing.size()-1; currentIndex++)
            {
                currentDistanceCheck += Math.sqrt((startOplossing.get(currentIndex).x - startOplossing.get(currentIndex+1).x) * (startOplossing.get(currentIndex).x - startOplossing.get(currentIndex+1).x) +
                        (startOplossing.get(currentIndex).y - startOplossing.get(currentIndex+1).y) * (startOplossing.get(currentIndex).y - startOplossing.get(currentIndex+1).y)
                );
            }
            float bestDistance = 0;
            for(int bestIndex = 0; bestIndex < best.size()-1; bestIndex++)
            {
                bestDistance += Math.sqrt((best.get(bestIndex).x - best.get(bestIndex+1).x) * (best.get(bestIndex).x - best.get(bestIndex+1).x) +
                        (best.get(bestIndex).y - best.get(bestIndex+1).y) * (best.get(bestIndex).y - best.get(bestIndex+1).y)
                );
            }
            if(currentDistanceCheck < bestDistance)
            {
                best.clear();
                best.addAll(startOplossing);
            }

            startTemp *= 1-cooling;
        }

        float bestDistance = 0;
        for(int bestIndex = 0; bestIndex < best.size()-1; bestIndex++)
        {
            bestDistance += Math.sqrt((best.get(bestIndex).x - best.get(bestIndex+1).x) * (best.get(bestIndex).x - best.get(bestIndex+1).x) +
                    (best.get(bestIndex).y - best.get(bestIndex+1).y) * (best.get(bestIndex).y - best.get(bestIndex+1).y)
            );
        }
        getBestOrderLocaties().addAll(best);
        setAftstand(bestDistance);
        long totalTime = System.nanoTime() / 1000 - startTime;
        setTime(totalTime);

    }

    public double acceptanceProbability(float oldDistance, float newDistance, double temperature) {
        // If the new solution is better, accept it
        if (newDistance < oldDistance) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((oldDistance - newDistance) / temperature);
    }
}
