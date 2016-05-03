/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

import java.time.LocalTime;

/**
 *
 * @author ace
 */
public class Route {
    private int afstand;
    private LocalTime verwachtDuur;
    
    //constructors

    public Route(int afstand) {
        this.afstand = afstand;
    }

    public Route(int afstand, LocalTime verwachtDuur) {
        this.afstand = afstand;
        this.verwachtDuur = verwachtDuur;
    }
    
    
    //setters
    public void setAfstand(int afstand) {
        this.afstand = afstand;
    }

    public void setVerwachtDuur(LocalTime verwachtDuur) {
        this.verwachtDuur = verwachtDuur;
    }
    
    
    //toString

    @Override
    public String toString() {
        return "Route{" + "afstand=" + afstand + ",  verwachtDuur=" + verwachtDuur + '}';
    }
    
    
    
    
}
