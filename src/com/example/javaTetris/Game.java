package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game (){
        figure = new Figure();
    }

    JFrame window;
    JComponent grid;
    Figure figure;
    int[][] currentFigure;

    public void step (){
        for (int y=0; y<4; y++){
            for (int x=0; x<4; x++){
                if (this.currentFigure[y][x]==1){
                    GridCells.gridStatus[x][y]=1;
                }
            }
        }
    }

    public int[][] getNewFigure(){
        return figure.getNewFigure();
    }

    public void setWindow (){
        this.window = new JFrame();
        this.window.setSize(315,637);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setTitle("Tetris");
        this.window.getContentPane().setBackground(Color.CYAN);
        this.grid = new GridCells();
        this.window.add(grid);
        this.window.setVisible(true);
    }

}
