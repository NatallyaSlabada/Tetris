package com.example.javaTetris;

import javafx.event.EventDispatcher;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Random;

public class Tetris {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        boolean isGameOver = false;

        Game game = new Game();
        game.setWindow();
        game.setFigureOnField();

        while (!game.isLanded){
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            game.figureY++;
            game.step(game.figureX, game.figureY);
            game.window.repaint();
        }


    }
}
