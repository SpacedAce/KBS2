package me.TSP;

public class Vak
{
    public int x;
    public int y;
    public int vakNr;

    public Vak(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.vakNr = (y*10 + x);
    }
    public Vak(int x, int y, int vakNr){
        this.x = x;
        this.y = y;
        this.vakNr = vakNr;
    }



    @Override
    public String toString(){
        return x + ":" + y;
    }
}
