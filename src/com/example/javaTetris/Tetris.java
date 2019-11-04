package com.example.javaTetris;

import javafx.event.EventDispatcher;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;

public class Tetris {
    public static void sleep (int milis){
        try {
            Thread.sleep(milis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        tetris.startGame();
    }

    public void startGame (){
        Timer timer = new Timer();
        Game game = new Game(700);
        game.setWindow();
        GridCellsDelegate gridCellsDelegate = game.gridCells;
        game.setFigureOnField();
        game.repaintGrid();
        sleep(300);
        while (!game.isGameOver){
            if (game.gridCells.figure.isLanded){
                game.setFigureOnField();
                game.repaintGrid();
            }
            else {
                game.updateGrid();
                if (game.gridCells.figure.isLanded){
                    game.repaintGrid();
                    timer.schedule(new MyTimer(game),300);
                    /*game.removeFilledLines();
                    sleep(500);*/
                }
                game.repaintGrid();
            }
            sleep(game.getSpeed());
        }





        int userInput=-1;
        UIManager UI=new UIManager();
        UI.put("OptionPane.background", Color.GRAY);
        UI.put("Panel.background", Color.GRAY);
        UI.put("OptionPane.messageFont", new Font("Comic Sans MS", Font.BOLD, 17));
        UI.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));
        Object[] dialogOptions = {"Restart", "Finish"};
        while (userInput==-1){
            userInput = JOptionPane.showOptionDialog(
                    game.window,
                    "Your score:\n"+"    "+Integer.toString(game.score),
                    "GAME OVER",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src\\gameOver2.png"),
                    dialogOptions,
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
