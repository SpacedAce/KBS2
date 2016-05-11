
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
    private static final String driverName = "com.mysql.jdbc.Driver";
    
    public ASRS(String bestandslocatie) throws SQLException
    {
        ArrayList bestelling = XmlImport.XmlImportFromFile(bestandslocatie);
        ArrayList gegevens = XmlImport.XmlImportGegevensFromFile(bestandslocatie);
        ArrayList bestelling2 = XmlImport.XmlImportBestellingFromFile(bestandslocatie);
        
        System.out.println(bestelling);
        
        try
        {
            Class.forName(driverName).newInstance();
            
        }catch (ClassNotFoundException e){
            System.err.println(e.getMessage());
        }catch (InstantiationException e){
            System.err.println(e.getMessage());
        }catch (IllegalAccessException e){
            System.err.println(e.getMessage());
        }
        
        ArrayList<Artikel> artikelen = Database.getArtikelen();
        for(Artikel artikel : artikelen)
        {
            System.out.println(artikel.toString());
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
    
    

    public void setPakbon(File pakbon) {
        this.pakbon = pakbon;
    }

    public void setXmlOrder(File xmlOrder) {
        this.xmlOrder = xmlOrder;
    }
    
    
    
}
