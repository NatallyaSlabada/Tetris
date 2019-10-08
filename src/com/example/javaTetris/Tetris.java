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


        while (!isGameOver){
            game.setFigureOnField();
            while (!game.figure.isLanded){
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                game.figure.figureY++;
                game.step(game.figure.figureX, game.figure.figureY, game.figure);
                if (!game.figure.isDownMovementPossible){
                    game.figure.figureY--;
                    game.step(game.figure.figureX, game.figure.figureY, game.figure);
                    game.figure.isLanded = true;
                }
                if (game.figure.isLanded){
                    game.toStableGrid(game.figure.figureX, game.figure.figureY);
                }
                game.window.repaint();
            }
        }



    }
}
