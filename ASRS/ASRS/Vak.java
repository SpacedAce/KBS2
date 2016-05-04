package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

/**
 *
 * @author ace
 */
public class Vak {
    private int coordinaat_X;
    private int coordinaat_Y;
    private String vakNummer;
    
    
    //constructors
    public Vak(int coordinaat_X, int coordinaat_Y) {
        this.coordinaat_X = coordinaat_X;
        this.coordinaat_Y = coordinaat_Y;
    }

    public Vak(int coordinaat_X, int coordinaat_Y, String vakNummer) {
        this.coordinaat_X = coordinaat_X;
        this.coordinaat_Y = coordinaat_Y;
        this.vakNummer = vakNummer;
    }
    
    //setters

    public void setCoordinaat_X(int coordinaat_X) {
        this.coordinaat_X = coordinaat_X;
    }

    public void setCoordinaat_Y(int coordinaat_Y) {
        this.coordinaat_Y = coordinaat_Y;
    }

    public void setVakNummer(String vakNummer) {
        this.vakNummer = vakNummer;
    }
    
    //toString

    @Override
    public String toString() {
        return "Vak{" + "coordinaat X =" + coordinaat_X + ", coordinaat Y =" + coordinaat_Y + ", vakNummer=" + vakNummer + '}';
    }
    
    
}
