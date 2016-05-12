/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

import java.util.ArrayList;

/**
 *
 * @author ace
 */
public class TSP {
    private ArrayList<Vak> vak;
    private ArrayList<Integer> route;

    public TSP(ArrayList<Vak> vak) {
        this.vak = vak;
        System.out.println(">Recieved Vakken from ASRS");
        System.out.println("  Calculating Route.....Done!");
        System.out.println(">Forward calculated Route to ASRS");
        System.out.println();
        
    }

    public ArrayList<Vak> getRoute() {
        return vak;
    }
    
    
}