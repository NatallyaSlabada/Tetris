package com.example.javaTetris;

import javax.swing.*;

public interface GameDelegate {
    void repaintGrid ();
    int getAccelerationSpeed();
    int getSpeedBuffer();
    void setSpeed (int speed);
}
