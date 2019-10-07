package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game() {

    }

    JFrame window;
    JComponent grid;
    Figure figure;

    int[][] currentFigure;

    public void setFigureOnField() {
        currentFigure = getNewFigure();
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (this.currentFigure[y][x] == 1) {
                    GridCells.gridMovement[x + figure.figureX][y + figure.figureY] = 1;
                }
            }
        }
    }

    public void step(int figureX, int figureY) {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                GridCells.gridMovement[x][y] = 0;
            }
        }

        for (int y = 1; y > -1; y--) {
                for (int x = 0; x < 4; x++) {
                    if (this.currentFigure[y][x] == 1) {
                        if(GridCells.gridStable[x + figureX][y + figureY]!=1){
                            GridCells.gridMovement[x + figureX][y + figureY] = 1;
                        }
                        else {
                            figure.isMovementPossible = false;
                        }
                    }
                }
            if ((y + figureY )==19){
                figure.isLanded = true;
            }
        }
    }

    public void toStableGrid (int figureX, int figureY){
        for (int y = 1; y > -1; y--) {
            for (int x = 0; x < 4; x++) {
                if (this.currentFigure[y][x] == 1) {
                    GridCells.gridStable[x + figureX][y + figureY] = 1;
                }
            }
        }
    }

    public int[][] getNewFigure() {
        figure = new Figure();
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
