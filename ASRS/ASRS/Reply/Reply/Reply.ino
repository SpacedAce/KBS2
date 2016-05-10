void setup(){
 Serial.begin(9600);
 
}

void loop(){
  if(Serial.available())
  {
    char reading = Serial.read();   
    Serial.println(reading);
    Serial.write(reading);
  }
  
}
