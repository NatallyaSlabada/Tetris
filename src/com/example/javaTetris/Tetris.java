package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;
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
                    timer.schedule(new GameTimer(game),300);
                }
                game.repaintGrid();
            }
            sleep(game.getSpeed());
        }
        userDialog(game.window, game.score);
    }

    private void userDialog(JFrame frame, int score) {
        int userInput=-1;
        UIManager UI=new UIManager();
        UI.put("OptionPane.background", Color.GRAY);
        UI.put("Panel.background", Color.GRAY);
        UI.put("OptionPane.messageFont", new Font("Comic Sans MS", Font.BOLD, 17));
        UI.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));
        Object[] dialogOptions = {"Restart", "Finish"};
        while (userInput==-1){
            userInput = JOptionPane.showOptionDialog(
                    frame,
                    "Your score:\n"+"    "+score,
                    "GAME OVER",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src\\gameOver2.png"),
                    dialogOptions,
                    null
            );
            switch (userInput){
                case 0:{
                    frame.dispose();
                    startGame();
                    break;
                }
                case 1:{
                    frame.dispose();
                    break;
                }
            }
        }
    }
}
