package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game() {
        figure = new Figure();
    }

    JFrame window;
    JComponent grid;
    Figure figure;
    int figureX = 3;
    int figureY = 0;
    boolean isLanded = false;
    int[][] currentFigure;

    public void setFigureOnField() {
        currentFigure = getNewFigure();
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (this.currentFigure[y][x] == 1) {
                    GridCells.gridStatus[x + this.figureX][y + this.figureY] = 1;
                }
            }
        }
    }

    public void step(int figureX, int figureY) {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                GridCells.gridStatus[x][y] = 0;
            }
        }
        for (int y = 0; y < 2; y++) {

                for (int x = 0; x < 4; x++) {
                    if (this.currentFigure[y][x] == 1) {
                        GridCells.gridStatus[x + figureX][y + figureY] = 1;
                    }
                }
            if ((y + figureY + 1)>20) isLanded = true;
        }
    }

    public int[][] getNewFigure() {
        return figure.getNewFigure();
    }

    public void setWindow() {
        this.window = new JFrame();
        this.window.setSize(315, 637);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setTitle("Tetris");
        this.window.getContentPane().setBackground(Color.CYAN);
        this.grid = new GridCells();
        this.window.add(grid);
        this.window.setVisible(true);
    }

}
