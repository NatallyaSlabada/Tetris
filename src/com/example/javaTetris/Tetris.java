package com.example.javaTetris;

import javafx.event.EventDispatcher;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tetris {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        boolean isGameOver = false;

        Game game = new Game();
        game.setWindow();
        game.speed = 800;


        while (!isGameOver){
            game.setFigureOnField();
            while (!game.figure.isLanded){
                try {
                    Thread.sleep(game.speed);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                game.figure.figureY++;
                game.step(game.figure.figureX, game.figure.figureY, Move.DOWN);
                if (game.figure.isReachedBottomBorder){
                    game.figure.isLanded = true;
                }
                if (!game.figure.isDownMovementPossible){
                    game.figure.figureY--;
                    game.step(game.figure.figureX, game.figure.figureY, Move.DOWN);
                    game.figure.isLanded = true;
                }
                if (game.figure.isLanded){
                    game.toStableGrid(game.figure.figureX, game.figure.figureY);
                }
                System.out.println("Время перед репейнтом в главном движении " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
                game.window.repaint();
            }
        }



    }
}
