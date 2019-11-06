package com.example.javaTetris;

import java.util.TimerTask;

public class GameTimer extends TimerTask {
    Game game;
    public GameTimer(Game game){
        this.game = game;
    }
    public void run() {
        game.removeFilledLines();
    }
}
