/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

/**
 *
 * @author ace
 */
public class Artikel {
    private int artikelnummer;
    private String naam;
    private int lengte;
    private int breedte;
    private int hoogte;
    
    
    
    //Constructors
    public Artikel(int artikelnummer, String naam, int lengte, int breedte, int hoogte) {
        this.artikelnummer = artikelnummer;
        this.naam = naam;
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    //Setters
    public void setArtikelnummer(int artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public void setBreedte(int breedte) {
        this.breedte = breedte;
    }

    public void setHoogte(int hoogte) {
        this.hoogte = hoogte;
    }
    
    //toString

    @Override
    public String toString() {
        return "Artikel{" + "artikelnummer=" + artikelnummer + ", naam=" + naam + ", lengte=" + lengte + ", breedte=" + breedte + ", hoogte=" + hoogte + '}';
    }
    
    
    
    
    
}
