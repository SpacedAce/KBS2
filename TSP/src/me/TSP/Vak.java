package me.TSP;

public class Vak
{
    public int x;
    public int y;

    public Vak(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return x + ":" + y;
    }
}
