
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import java.io.File;



public class ASRS {
    private Order order;
    private File pakbon;
    private File xmlOrder;
    
    /**
     * filter de XML met XmlImport
     * aan de hand van de XmlImportBestellingFromFile kunne de atikelgegevens opgehaald worden uit database
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
