//hoi

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import java.util.ArrayList;






public class ASRSmain {  
    
    public static boolean debug = true;
        
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
        String locatie = "C:/Users/Charlene/Documents/Github/KBS2/ASRS/ASRS/order.xml";
        ASRS asrs = new ASRS(locatie);
                        
        //Scherm scherm = new Scherm();
        
        
    }
    
}
