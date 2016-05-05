
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import javax.swing.*;





public class Menu extends JPanel{
    private JButton buttonSelectXML,
                    buttonSelectPakbon, 
                    buttonGenerate, 
                    buttonStart;
    private JTextField fieldXML; 
    
    //constructors    
    public Menu(){
        
        add(fieldXML = new JTextField(10));
        setVisible(true);
        
    }
    
    
    
    
    
    
}
