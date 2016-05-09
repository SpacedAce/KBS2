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
        Vak een = new Vak(1, 1, 99);
        Vak twee = new Vak(2, 1, 33);
        Vak drie = new Vak(3, 1, 99);
        Vak vier = new Vak(4, 1, 99);
        Vak vijf = new Vak(5, 1, 99);
        ArrayList<Vak> locatia = new ArrayList<>();
        locatia.add(een);
        locatia.add(twee);
        locatia.add(drie);
        locatia.add(vier);
        locatia.add(vijf);
        SimpelGretig wille = new SimpelGretig();
        wille.calculate(locatia);
    }
}
