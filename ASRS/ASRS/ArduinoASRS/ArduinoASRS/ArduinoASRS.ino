// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01."
// -------------------------------------------- //

// Includes
#include <avr/interrupt.h>


// Ledpinnen
const byte ledPin1 = 6;
const byte ledPin2 = 7;

// Interrupt pinnen
const byte interruptPin1 = 2;
const byte interruptPin2 = 3;

// 
volatile int value1 = 0;
volatile int value2 = 0;

// State geheugen,
//  door het keyword volatile
//  wordt er gebruik gemaakt van RAM-geheugen
//  in plaats van opslaggeheugen
volatile byte state1 = LOW;
volatile byte state2 = LOW;


void setup(){
  // Serieele verbinding maken
  Serial.begin(9600);
  Serial.print("Starting Serial connection");
  Serial.println(".....Done!");
  
  // Ledpinnen als output instellen
  Serial.print("Configuring outputs");  
  pinMode(ledPin1, OUTPUT);
  pinMode(ledPin2, OUTPUT);
  Serial.println(".....Done!");
  
  // Interrupt als input instellen
  Serial.print("Configuring inputs");
  pinMode(interruptPin1, INPUT);
  pinMode(interruptPin2, INPUT);
  Serial.println(".....Done!");
  
  //intterupt instellen en starten
  Serial.print("Initializing interrupts");
  //GICR |= ( 1 << INT0);
  sei();
  EIMSK |= ( 1 << INT0);
  EIMSK |= ( 1 << INT1);
  EICRA |= ( 1 << ISC00);
  EICRA |= ( 1 << ISC01);
  
  Serial.println(".....Done!");
  
  //attachInterrupt(digitalPinToInterrupt(interruptPin1), blink1, RISING);
  //attachInterrupt(digitalPinToInterrupt(interruptPin2), blink2, RISING);
  
  
}

ISR(INT0_vect){
  value1 = digitalRead(interruptPin1);
    
}

ISR(INT1_vect){
  value2 = digitalRead(interruptPin2);
  
}


void loop(){
  if(value1 == 1){
    digitalWrite(ledPin1, HIGH);
    delay(1000);
    digitalWrite(ledPin1, LOW);
  }
  if(value2){
    digitalWrite(ledPin2, HIGH);
    delay(1000);
    digitalWrite(ledPin2, LOW);
    
  }
  
}
