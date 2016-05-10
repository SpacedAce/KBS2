/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import java.util.ArrayList;






public class ASRSmain {
    public static void main(String[] arg) throws Exception 
    {
//        SerialConnection arduino1 = new SerialConnection();
//		arduino1.initialize();
//		Thread t=new Thread() {
//			public void run() {
//				//the following line will keep this app alive for 1000 seconds,
//				//waiting for events to occur and responding to them (printing incoming messages to console).
//				try {Thread.sleep(1000000);
//                                arduino1.writeData("2");
//                                //arduino1.serialEvent();
//                                
//                                } catch (InterruptedException ie) {}
//			}
//		};
//		t.start();
//		System.out.println("Thread Started");
//                
//                Scherm scherm = new Scherm();
      
        ArrayList bestelling = XmlImport.XmlImportFromFile("/home/ace/KBS2/Code/PrivateKBS2/ASRS/ASRS/order.xml");
        ArrayList gegevens = XmlImport.XmlImportGegevensFromFile("/home/ace/KBS2/Code/PrivateKBS2/ASRS/ASRS/order.xml");
        ArrayList bestelling2 = XmlImport.XmlImportBestellingFromFile("/home/ace/KBS2/Code/PrivateKBS2/ASRS/ASRS/order.xml");
        
        System.out.println(bestelling);
        System.out.println(gegevens);
        System.out.println(bestelling2);
        
        Scherm scherm = new Scherm();
        
        
    }
    
}
