package me.TSP;

import java.util.ArrayList;

/**
 * Created by Kevin on 29-4-2016.
 */
public class TwoOptAlgoritme extends Algoritme
{
    public TwoOptAlgoritme()
    {
        super.setName("Two-Opt Algoritme");
    }

    @Override
    public void calculate(ArrayList<Vak> locaties) {
        ArrayList<Vak> currentSolution = new ArrayList<>();
        currentSolution.addAll(locaties);

        ArrayList<Vak> newSolution = new ArrayList<>();
        while(currentSolution.size() > 0) {
            int bestIndex = 1;
            for (int i = 1; i < currentSolution.size(); i++)
            {

            }
            newSolution.add(currentSolution.get(bestIndex));
            currentSolution.remove(bestIndex);
        }
    }
}
