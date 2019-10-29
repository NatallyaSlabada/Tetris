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
        Game game = new Game(700);
        game.setWindow();
        GridCellsDelegate gridCellsDelegate = game.gridCells;
        while (!game.isGameOver){
            game.setFigureOnField();
            while (!gridCellsDelegate.figureGetLanded()){
                try {
                    Thread.sleep(game.getSpeed());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gridCellsDelegate.setFigureY(gridCellsDelegate.getFigureY()+1);
                //System.out.println("Ending step in Tetris: "+Thread.currentThread().getName()+" Time:"+ new SimpleDateFormat("ss.SSS").format(new Date()));
                //System.out.println("isReachedBottomBorder "+game.figure.isReachedBottomBorder);
                if (!gridCellsDelegate.figureGetReachedBottomBorder()){
                    gridCellsDelegate.step(Move.DOWN);
                }
                else {
                    gridCellsDelegate.setFigureY(gridCellsDelegate.getFigureY()-1);
                }
                if (gridCellsDelegate.figureGetReachedBottomBorder()){
                    try {
                        Thread.sleep(80);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    gridCellsDelegate.figureSetLanded(true);
                }
                if (!gridCellsDelegate.figureGetDownMovementPossible()){
                    gridCellsDelegate.setFigureY(gridCellsDelegate.getFigureY()-1);
                    gridCellsDelegate.step(Move.DOWN);
                    gridCellsDelegate.figureSetLanded(true);
                }
                if (gridCellsDelegate.figureGetLanded()){
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    game.removeFilledLines();
                }
                game.repaintGrid();
            }
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
