// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01."
// -------------------------------------------- //

// Includes
#include <avr/interrupt.h>
#include <SoftwareSerial.h>


// Interrupt pinnen
  const int interruptPin1 = 2;
  const int interruptPin2 = 3;
  
  int buttonState;
  int lastButtonState = LOW;
  
  long lastDebounceTime = 0;
  long debounceDelay = 50;
  
  SoftwareSerial portOne(1,0);
    
void setup()
{
  // Serieele verbinding maken
  Serial.begin(9600);
  portOne.begin(9600);
  Serial.println();
  Serial.println("Starting Serial connection.....Done!");  
    
  // Interrupt als input instellen
  Serial.print("Configuring inputs");
  pinMode(interruptPin1, INPUT);
  pinMode(interruptPin2, INPUT);
  Serial.println(".....Done!");
  
  //interrupt instellen en starten
  Serial.print("Initializing interrupts");
  attachInterrupt(0, interrupt1, RISING);
  attachInterrupt(1, interrupt2, RISING); 
  Serial.println(".....Done!");
}
  

//Interrupt Routine van pin 2
void interrupt1()
{ 
  Serial.println("Interrupt 1");
     
}


//Interrupt Routine van pin 3
void interrupt2()
{ 
  Serial.println("Interrupt 2");
 
}


void loop() 
{
  delay(500);
  Serial.println("Soep");
  
}
