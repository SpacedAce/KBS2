
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import java.io.File;
import java.sql.*;
import java.util.ArrayList;



public class ASRS
{
    private Order order;
    private File pakbon;
    private File xmlOrder;
    private ArrayList<Vak> vakken = new ArrayList<Vak>();
    //private static final String driverName = "com.mysql.jdbc.Driver";
    
    public ASRS(String bestandslocatie) throws SQLException
    { 
        // XML importeren en in ArrayList plaatsen.
        ArrayList<String> bestelling = XmlImport.XmlImportBestellingFromFile(bestandslocatie);        
            if(ASRSmain.debug)
            {
                System.out.println(">>XML import<");
                System.out.println(" " + bestelling);
                System.out.println(">Forward to database");
                System.out.println(" ");
            }
        
        // Artikelen uit de XML opvragen uit de database.     
        ArrayList<Artikel> artikelen = Database.getArtikelen(bestelling);
            if(ASRSmain.debug)
            {   
                System.out.println();
                System.out.println(">Recieved artikelen from database");
                for(Artikel ar : artikelen)
                {
                   System.out.println("  " + ar); 
                }
                System.out.println();
            }
        // Uit de opgevraagde Artikelen de Vakken filteren.                
        for(Artikel art : artikelen)
        {            
            vakken.add(art.getVak());
        }
            if(ASRSmain.debug)
            {
                System.out.println(">Filter vakken from querry ");
                for(Vak v: vakken)
                {
                    System.out.println("  " + v);
                }
                System.out.println(">Forward Vakken to TSP");
                System.out.println();
            }
        
        // Bepaal de gunstigste route m.b.v. de TSP-applicatie.
        TSP tsp = new TSP(vakken);
        ArrayList<Vak> route = tsp.getRoute();
            if(ASRSmain.debug)
            {
                System.out.println(">Recieved Route from TSP");
                for(Vak rt : route){
                    System.out.println(" " + rt);
                }
                System.out.println(">Forward Route to warehouse Arduino");
                System.out.println("");
            }
    }
    
    /**
     * 
     * aan de hand van de XmlImportBestellingFromFile kunnen
     * de juiste atikelgegevens opgehaald worden uit database.
     * 
     * er word een order gemaakt en daarin worden artikelen geplaatst?
     * 
     * 
     * van de artikelen wordt een order aangemaakt ?
     * 
     * 
     * 
     * 
     * @param pakbon 
     */
    
    
    //Setters
    public void setPakbon(File pakbon) 
    {
        this.pakbon = pakbon;
    }

    public void setXmlOrder(File xmlOrder) 
    {
        this.xmlOrder = xmlOrder;
    }

    
    // Getters
    public ArrayList<Vak> getVakken()
    {        
        return this.vakken;
    }

}
