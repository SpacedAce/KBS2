package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

/**
 *
 * @author ace
 */
public class Vak {
    private int coordinaat_X;
    private int coordinaat_Y;    
    
    // Setters
    public void setCoordinaat_X(int coordinaat_X) {
        this.coordinaat_X = coordinaat_X;
    }

    public void setCoordinaat_Y(int coordinaat_Y) {
        this.coordinaat_Y = coordinaat_Y;
    }
    
    
    // Getters
    public int getCoordinaat_X() {
        return coordinaat_X;
    }

    public int getCoordinaat_Y() {
        return coordinaat_Y;
    }
    
    

    //toString
    @Override
    public String toString() {
        return "Vak{" + "coordinaat X =" + coordinaat_X + ", coordinaat Y =" + coordinaat_Y + '}';
    }
    
    
}
