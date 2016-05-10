package me.TSP;

import java.util.ArrayList;

/**
 * Created by Kevin on 29-4-2016.
 */
public class TSPMain
{
    public static void main(String[] arg)
    {
        //TSP tsp = new TSP();
        Vak een = new Vak(3, 3, 99);
        Vak twee = new Vak(1, 2, 33);
        Vak drie = new Vak(4, 2, 99);
        Vak vier = new Vak(5,5,99);
        ArrayList<Vak> locatia = new ArrayList<>();
        locatia.add(een);
        locatia.add(twee);
        locatia.add(drie);
        locatia.add(vier);
        TwoOptAlgoritme wille = new TwoOptAlgoritme();
        wille.calculate(locatia);
    }
}
