package me.TSP;

import java.util.ArrayList;

/**
 * Created by Kevin on 29-4-2016.
 */
public class TSPMain
{
    public static void main(String[] arg)
    {
        TSP tsp = new TSP();
        Vak vak1 = new Vak(1, 2);
        Vak vak2 = new Vak(2, 2);
        Vak vak3 = new Vak(3, 3);
        Vak vak4 = new Vak(4, 4);
        ArrayList<Vak> lijst = new ArrayList<>();
        lijst.add(vak1);
        lijst.add(vak2);
        lijst.add(vak3);
        lijst.add(vak4);
        WillekeurigAlgoritme rand = new WillekeurigAlgoritme();
        rand.calculate(lijst);
    }
}
