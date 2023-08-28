#include <Arduino.h>
#include "SimpleTraficLIght.h"

//SimpleLED led1(LED_BUILTIN, false, 50,200);
//SimpleLED led2(LED_BUILTIN_AUX, false, 50,150);

SimpleTraficLight light(D0,D1,D2,D5,D6,D7,(long[]){1000,1000,1000,1000,1000,1000,1000,1000});


void setup()
{
  // put your setup code here, to run once:
  long start = millis();
  light.setup(start);
  //led1.setup(start);
  //led2.setup(start);

  
}

void loop()
{
  // put your main code here, to run repeatedly:
  long now = millis();
  light.update(now);
  //led1.update(now);
  //led2.update(now);
}

