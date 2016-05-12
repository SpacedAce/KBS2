
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


public class Database 
{
    
    private static final String username = "user";
    private static final String password = "kbsKBS123";
    private static final String dbName = "KBS2";
    private static final String serverUrl = "//86.86.212.234";
    private static final String serverPort = "3306";
    private static final String dbms = "mysql";
    private static final String driverName = "com.mysql.jdbc.Driver";   
    
    
    
    private static Connection getDBConnection() throws SQLException 
    {
        System.out.print("Connecting to database");
        
        Connection dbconnection = null;
        Properties connectionProperties = new Properties();
        
        connectionProperties.put("user", username);
        connectionProperties.put("password", password);
        
        
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
        
        
        try
        {            
            dbconnection = DriverManager.getConnection(
                    "jdbc:" + dbms + ":" + 
                    serverUrl + ":" + serverPort + "/" + dbName
                    , connectionProperties);
            
            System.out.println(".....Done!");
            //debug
            //System.out.println("succes"+ dbconnection);
            return dbconnection;
            
        }catch(SQLException e)
        {            
            System.out.println(".....Failed!");            
            System.err.println(e.getMessage());
            //debug
            //System.out.println("Fail"+ dbconnection);
            
        }
        
        
        
        
        return dbconnection;
    }
    
    
    
    public static ArrayList<Artikel> getArtikelen(ArrayList bestelling) throws SQLException
    {
        ArrayList<Artikel> artikelen = new ArrayList<>();
        ArrayList<String> bestelling2 = new ArrayList<String>(bestelling);
        Connection dbConnection = null;
        PreparedStatement pstmt = null;
        
        try
        {
            dbConnection = getDBConnection();            
            pstmt = dbConnection.prepareStatement("SELECT * FROM artikel WHERE artikelID = ? ");
            for(String be : bestelling2){                
                if(!be.equals(bestelling.get(0)))
                {
                    pstmt.setInt(1, Integer.parseInt(be));                    
                    ResultSet resultaat = pstmt.executeQuery();
                    
                    if(resultaat.next())
                    {
                        Artikel art = null;
                        int artikelID = resultaat.getInt("artikelID");
                        String naam = resultaat.getString("naam");
                        int breedte = resultaat.getInt("breedte");
                        int hoogte = resultaat.getInt("hoogte");
                        int locatiex = resultaat.getInt("locatiex");
                        int locatiey = resultaat.getInt("locatiey");
                        art = new Artikel(artikelID, naam, breedte, hoogte, locatiex, locatiey);
                        artikelen.add(art);
                    }
                }
            }
            
        } catch (SQLException e)
        {            
            System.err.println(e.getMessage());
            
        } finally
        {
            if (pstmt != null)
            {
                pstmt.close();
            }
            
            if(dbConnection != null)
            {                
                dbConnection.close();
            }
        }    
                
        return artikelen;
    }
    
    
    
    
    
    
    
}



