package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tetris {
    public static void main(String[] args) {
        Game game = new Game();
        game.setWindow();
        game.setFigureOnField();
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        game.step(2);


        game.window.repaint();

    }
}
