
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import java.awt.*;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;




public class Scherm extends JFrame{
    //private Status status;
    //private XMLPakbon xmlPakbon;
    //private Menu menu;
    
    public Scherm(){
    setTitle("ASRS-Systeem");
        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(1, 2));
        
        
        
        setVisible(true);
    }
    Menu menu = new Menu();
    
    
    
     
        
    
}
