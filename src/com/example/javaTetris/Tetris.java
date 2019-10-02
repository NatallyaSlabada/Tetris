package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tetris {
    public static void main(String[] args) {
        Game game = new Game();
        game.setWindow();
        game.setFigureOnField();

        for (int x=0; x<19; x++){
            try {
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            game.step(x+1);
            game.window.repaint();
        }
    }
}
