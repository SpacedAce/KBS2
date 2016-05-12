package me.TSP;

import java.util.ArrayList;

public class TwoOptAlgoritme extends Algoritme
{
    public TwoOptAlgoritme()
    {
        super.setName("Two-Opt Algoritme");
    }

    @Override
    public void calculate(ArrayList<Vak> locaties) {
        long startTime = System.nanoTime() / 1000;
        ArrayList<Vak> currentSolution = new ArrayList<>();
        currentSolution.addAll(locaties);

        Vak zeroPoint = new Vak(0, 5);

        ArrayList<Vak> newSolution = new ArrayList<>();
        currentSolution.add(0,zeroPoint);
        newSolution.add(0,zeroPoint);
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
            newSolution.add(currentSolution.get(bestIndex));
            Vak newStartPoint = currentSolution.get(bestIndex);
            currentSolution.remove(bestIndex);
            currentSolution.remove(0);
            currentSolution.add(0, newStartPoint);
        }
        newSolution.add(zeroPoint);
        //getBestOrderLocaties().addAll(newSolution);
        float distance = 0;
        for(int bestIndex = 0; bestIndex < newSolution.size()-1; bestIndex++)
        {
            distance += Math.sqrt((newSolution.get(bestIndex).x - newSolution.get(bestIndex+1).x) * (newSolution.get(bestIndex).x - newSolution.get(bestIndex+1).x) +
                    (newSolution.get(bestIndex).y - newSolution.get(bestIndex+1).y) * (newSolution.get(bestIndex).y - newSolution.get(bestIndex+1).y)
            );
        }
        //setAftstand(distance);
        int improved = 0;
        while(improved < 20)
        {
            for(int i = 0; i < newSolution.size(); i++)
            {
                for(int k = i + 1; k < newSolution.size()-1; k++)
                {
                    ArrayList<Vak> improvedSolution = TwoOptSwap(newSolution, i, k);
                    //System.out.println("Out Locaties: " + improvedSolution);
                    float improvedDistance = 0;
                    for(int improvedIndex = 0; improvedIndex < improvedSolution.size()-1; improvedIndex++)
                    {
                        improvedDistance += Math.sqrt((improvedSolution.get(improvedIndex).x - improvedSolution.get(improvedIndex+1).x) * (improvedSolution.get(improvedIndex).x - improvedSolution.get(improvedIndex+1).x) +
                                (improvedSolution.get(improvedIndex).y - improvedSolution.get(improvedIndex+1).y) * (improvedSolution.get(improvedIndex).y - improvedSolution.get(improvedIndex+1).y)
                        );
                    }
                    if(improvedDistance < distance)
                    {
                        newSolution.clear();
                        newSolution.addAll(improvedSolution);
                    }
                }
            }
            improved++;
        }
        int newDistance = 0;
        for(int bestIndex = 0; bestIndex < newSolution.size()-1; bestIndex++)
        {
            newDistance += Math.sqrt((newSolution.get(bestIndex).x - newSolution.get(bestIndex+1).x) * (newSolution.get(bestIndex).x - newSolution.get(bestIndex+1).x) +
                    (newSolution.get(bestIndex).y - newSolution.get(bestIndex+1).y) * (newSolution.get(bestIndex).y - newSolution.get(bestIndex+1).y)
            );
        }
        getBestOrderLocaties().addAll(newSolution);
        setAftstand(newDistance);
        long totalTime = System.nanoTime() / 1000 - startTime;
        setTime(totalTime);
    }

    public ArrayList<Vak> TwoOptSwap(ArrayList<Vak> locs, int i, int k)
    {
        ArrayList<Vak> newArray = new ArrayList<>();
        for(int im = 0;  im < i+1; im++)
        {
            newArray.add(locs.get(im));
        }
        for(int im = k; im > i; im--)
        {
            newArray.add(locs.get(im));
        }
        for(int im = k+1; im < locs.size(); im++)
        {
            newArray.add(locs.get(im));
        }
        return newArray;
    }
}
