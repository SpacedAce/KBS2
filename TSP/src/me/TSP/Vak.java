package me.TSP;

public class Vak
{
    private int x;
    private int y;
    private int vakNr;

    public Vak(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.vakNr = (x*10 + y);
    }
    public Vak(int x, int y, int vakNr){
        this.x = x;
        this.y = y;
        this.vakNr = vakNr;
    }

    @Override
    public String toString(){
        return x + ", " + y;
    }
}
