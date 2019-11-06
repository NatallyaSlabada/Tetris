package com.example.javaTetris;

public interface GameDelegate {
    void repaintGrid ();
    int getAccelerationSpeed();
    int getSpeedBuffer();
    void setSpeed (int speed);
}
