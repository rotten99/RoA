#include "Arduino.h"
#include "SimpleTraficLight.h"

SimpleTraficLight::SimpleTraficLight(int r1pin, int y1pin, int g1pin, int r2pin, int y2pin, int g2pin, long stateTime[])
: _r1pin(r1pin), _y1pin(y1pin), _g1pin(g1pin), _r2pin(r2pin), _y2pin(y2pin), _g2pin(g2pin), _nextChange(0), _state(0)
{
    for(int i; i < 8; ++i){
        _stateTime[i] = stateTime[i];
    }
}

void SimpleTraficLight::setup(long startTime)
{
    pinMode(_r1pin,OUTPUT);
    pinMode(_y1pin,OUTPUT);
    pinMode(_g1pin,OUTPUT);
    pinMode(_r2pin,OUTPUT);
    pinMode(_y2pin,OUTPUT);
    pinMode(_g2pin,OUTPUT);
    _nextChange = startTime + _stateTime[0];
}

void SimpleTraficLight::update(long now)
{
    if(now < _nextChange) return;
    switch (_state)
    {
    case 0:
        digitalWrite(_y2pin,LOW);
        digitalWrite(_r1pin, HIGH);
        digitalWrite(_r2pin, HIGH);
        break;
    case 1:
        digitalWrite(_y1pin, HIGH);
        break;
    case 2:
        digitalWrite(_r1pin, LOW);
        digitalWrite(_y1pin, LOW);
        digitalWrite(_g1pin,HIGH);
        break;
    case 3:
        digitalWrite(_g1pin, LOW);
        digitalWrite(_y1pin, HIGH);
        break;
    case 4:
        digitalWrite(_y1pin, LOW);
        digitalWrite(_r1pin, HIGH);
        break;
    case 5:
        digitalWrite(_y2pin, HIGH);
        break;
    case 6:
        digitalWrite(_r2pin, LOW);
        digitalWrite(_y2pin, LOW);
        digitalWrite(_g2pin, HIGH);
        break;
    case 7:
        digitalWrite(_g2pin, LOW);
        digitalWrite(_y2pin, HIGH);            
        break;
    default:
        break;
    }
    _state == 7 ? _state=0: _state++; 
    _nextChange +=_stateTime[_state];

}