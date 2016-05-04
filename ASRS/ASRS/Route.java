package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

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
