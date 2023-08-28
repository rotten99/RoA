#ifndef SIMPLETRAFICLIGHT_H
#define SIMPLETRAFICLIGHT_H

class SimpleTraficLight
{
    public:
        SimpleTraficLight(int r1pin, int y1pin, int g1pin, int r2pin, int y2pin, int g2pin, long stateTime[]);
        void setup(long startTime);
        void update(long now);
    private:
        int _r1pin;
        int _y1pin;
        int _g1pin;
        int _r2pin;
        int _y2pin;
        int _g2pin;
        long _nextChange;
        int _state;
        long _stateTime[8];
};

#endif