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
        Vak een = new Vak(4, 4, 99);
        Vak twee = new Vak(2, 3, 33);
        Vak drie = new Vak(4, 2, 99);
        ArrayList<Vak> locatia = new ArrayList<>();
        locatia.add(een);
        locatia.add(twee);
        locatia.add(drie);
        VolledigeEnumeratie wille = new VolledigeEnumeratie();
        wille.calculate(locatia);
    }
}
