package com.example.javaTetris;

import java.util.TimerTask;

public class MyTimer extends TimerTask {
    Game game;
    public MyTimer (Game game){
        this.game = game;
    }
    public void run() {
        game.removeFilledLines();
    }
}
