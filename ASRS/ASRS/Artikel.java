/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

/**
 *
 * @author ace
 */
public class Artikel extends Vak{
    
    private int artikelID;
    private String naam;
    private int breedte;
    private int hoogte;
    private Vak vak;
    
    
    
    //Constructors
    public Artikel(int artikelID, String naam, int breedte, int hoogte, int locatiex, int locatiey) {
        setCoordinaat_X(locatiex);
        setCoordinaat_Y(locatiey);
        this.artikelID = artikelID;
        this.naam = naam;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.vak = vak;
    }

    //Setters
    public void setArtikelnummer(int artikelID) {
        this.artikelID = artikelID;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBreedte(int breedte) {
        this.breedte = breedte;
    }

    public void setHoogte(int hoogte) {
        this.hoogte = hoogte;
    }
    
    public void setVak(Vak vak){
        this.vak = vak;
    }
    
    
    //Getters
    public int getArtikelID() {
        return artikelID;
    }

    public String getNaam() {
        return naam;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

       
    //toString

    @Override
    public String toString() {
        return "Artikel(" +  "artikelID=" + artikelID + ", naam=" + naam + ", breedte=" + breedte + ", hoogte=" + hoogte + '}';
    }

    
    
    
    
    
    
}
