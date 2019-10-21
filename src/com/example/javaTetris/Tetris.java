package com.example.javaTetris;

import javafx.event.EventDispatcher;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tetris {
    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        tetris.startGame();
    }

    public void startGame (){
        Game game = new Game();
        game.setWindow();
        game.speed = game.speedBuffer = 700;
        while (!game.isGameOver){
            game.setFigureOnField();
            while (!game.figure.isLanded){
                try {
                    Thread.sleep(game.speed);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                game.figure.figureY++;
                //System.out.println("Ending step in Tetris: "+Thread.currentThread().getName()+" Time:"+ new SimpleDateFormat("ss.SSS").format(new Date()));
                //System.out.println("isReachedBottomBorder "+game.figure.isReachedBottomBorder);
                if (!game.figure.isReachedBottomBorder){
                    game.step(game.figure.figureX, game.figure.figureY, Move.DOWN);
                }
                else {
                    game.figure.figureY--;
                }
                if (game.figure.isReachedBottomBorder){
                    try {
                        Thread.sleep(80);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    game.figure.isLanded = true;
                }
                if (!game.figure.isDownMovementPossible){
                    game.figure.figureY--;
                    game.step(game.figure.figureX, game.figure.figureY, Move.DOWN);
                    game.figure.isLanded = true;
                }
                if (game.figure.isLanded){
                    game.toStableGrid(game.figure.figureX, game.figure.figureY);
                    game.window.repaint();
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    game.cleanGridMovement();
                    game.removeFilledLines();
                }
                game.window.repaint();
            }
        }
        int userInput=-1;
        while (userInput==-1){
            userInput = JOptionPane.showOptionDialog(
                    game.window,
                    "Your score is "+Integer.toString(game.score),
                    "GAME OVER",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("C:\\gameOver2.jpg"),
                    game.dialogOptions,
                    null
            );
            switch (userInput){
                case 0:{
                    game.window.dispose();
                    startGame();
                    break;
                }
                case 1:{
                    game.window.dispose();
                    break;
                }
            }
        }
    }
}
