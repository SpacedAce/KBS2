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
        double temp = 10000;
        double coolingRate = 0.003;

        ArrayList<Vak> currentSolution = new ArrayList<>();
        currentSolution.addAll(locaties);
        Collections.shuffle(currentSolution);
        Vak zeroPoint = new Vak(0, 5, 99);
        currentSolution.add(0, zeroPoint);
        currentSolution.add(currentSolution.size(), zeroPoint);
        ArrayList<Vak> best = new ArrayList<>();
        best.addAll(currentSolution);

        while(temp > 1)
        {
            System.out.println(temp);
            ArrayList<Vak> newSolution = new ArrayList<>();
            newSolution.addAll(currentSolution);
            int random1 = (int)(newSolution.size()-1 * Math.random());
            int random2 = (int)(newSolution.size()-1 * Math.random());
            if(random1 == 0 || random2 == 0)
            {
                continue;
            }
            Collections.swap(newSolution, random1, random2);

            float currentDistance = 0;
            for(int currentIndex = 0; currentIndex < currentSolution.size()-1; currentIndex++)
            {
                currentDistance += Math.sqrt((currentSolution.get(currentIndex).x - currentSolution.get(currentIndex+1).x) * (currentSolution.get(currentIndex).x - currentSolution.get(currentIndex+1).x) +
                        (currentSolution.get(currentIndex).y - currentSolution.get(currentIndex+1).y) * (currentSolution.get(currentIndex).y - currentSolution.get(currentIndex+1).y)
                );
            }

            float newDistance = 0;
            for(int newIndex = 0; newIndex < newSolution.size()-1; newIndex++)
            {
                newDistance += Math.sqrt((newSolution.get(newIndex).x - newSolution.get(newIndex+1).x) * (newSolution.get(newIndex).x - newSolution.get(newIndex+1).x) +
                        (newSolution.get(newIndex).y - newSolution.get(newIndex+1).y) * (newSolution.get(newIndex).y - newSolution.get(newIndex+1).y)
                );
            }

            if(acceptanceProbability(currentDistance, newDistance, temp) > Math.random())
            {
                currentSolution.clear();
                currentSolution.addAll(newSolution);
            }

            float currentDistanceCheck = 0;
            for(int currentIndex = 0; currentIndex < currentSolution.size()-1; currentIndex++)
            {
                currentDistanceCheck += Math.sqrt((currentSolution.get(currentIndex).x - currentSolution.get(currentIndex+1).x) * (currentSolution.get(currentIndex).x - currentSolution.get(currentIndex+1).x) +
                        (currentSolution.get(currentIndex).y - currentSolution.get(currentIndex+1).y) * (currentSolution.get(currentIndex).y - currentSolution.get(currentIndex+1).y)
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
                best.addAll(currentSolution);
            }

            temp *= 1-coolingRate;
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

    public double acceptanceProbability(float energy, float newEnergy, double temperature) {
        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }
}
