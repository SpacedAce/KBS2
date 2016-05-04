/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ace
 */
public class Order {
    
    private ArrayList<String> artikelen;
    private Artikel artikel;
    private int orderNr;
    private String voornaam, achternaam, adres, postcode, plaats;
    //private LocalDate datum;
    private String datum;
    
    
    ArrayList<String> artl= new ArrayList<String>();
    
    //constructors
    public Order() {
    }
    
      
    
    //setters

   
    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
    
    
    
    //toString

    @Override
    public String toString() {
        return "Order{" + "artikelen=" + artl + ", artikel=" + artikel + ", orderNr=" + orderNr + ", voornaam=" + voornaam + ", achternaam=" + achternaam + ", adres=" + adres + ", postcode=" + postcode + ", plaats=" + plaats + ", datum=" + datum + '}';
    }
    
    //Custom Methods
    public void AddArtikel(String artikel){
        artl.add(artikel);
        
    }
    

    
    
    
    
    
}
