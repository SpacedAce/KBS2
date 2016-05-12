
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
        //XML importeren en in ArrayList plaatsen.
        ArrayList<String> bestelling = XmlImport.XmlImportFromFile(bestandslocatie);
        ArrayList<String> gegevens = XmlImport.XmlImportGegevensFromFile(bestandslocatie);
        ArrayList<String> bestelling2 = XmlImport.XmlImportBestellingFromFile(bestandslocatie);        
        
        ArrayList<Artikel> artikelen = Database.getArtikelen(bestelling2);
                        
            for(Artikel art : artikelen)
            {
                Vak vak = new Vak();
                vak.setCoordinaat_X(art.getCoordinaat_X());
                vak.setCoordinaat_Y(art.getCoordinaat_Y());
                vakken.add(vak);
                                
            }
        System.out.println(vakken);
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
    
    

    public void setPakbon(File pakbon) {
        this.pakbon = pakbon;
    }

    public void setXmlOrder(File xmlOrder) {
        this.xmlOrder = xmlOrder;
    }
    
    public ArrayList<Vak> getVakken(){        
        return this.vakken;
    }
    
}
