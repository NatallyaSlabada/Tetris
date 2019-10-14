package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game() {

    }
    int speed;
    JFrame window;
    JComponent grid;
    Figure figure;
    int[][] currentFigure;
    int[][] bufferFigure;
    int[][] temp;
    FigureAction figureAction = new FigureAction(this);

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

    public void step(int figureX, int figureY, Move moveDirection) {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                GridCells.gridMovement[x][y] = 0;
            }
        }

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (this.currentFigure[y][x] == 1) {
                    if(GridCells.gridStable[x + figureX][y + figureY]!=1){
                        GridCells.gridMovement[x + figureX][y + figureY] = 1;
                    }
                    else {
                        if (moveDirection==Move.DOWN){
                            figure.isDownMovementPossible = false;
                        }
                        else if (moveDirection==Move.LEFT || moveDirection==Move.RIGHT){
                            figure.isLeftRightMovementPossible = false;
                        }
                        else if (moveDirection==Move.ROTATION){
                            figure.isRotationPossible = false;
                        }
                    }
                }
                int boundCell = this.currentFigure[y][x]+GridCells.gridStable[x + figureX][y + figureY];
                switch (boundCell){
                    case 3:{
                        figure.isReachedBottomBorder = true;
                        break;
                    }
                    case -1:{
                        figure.isReachedRightBorder = true;
                    }
                }
            }
        }
    }

    public void toStableGrid (int figureX, int figureY){
        for (int y = 0; y < 4; y++) {
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
        grid.addKeyListener(figureAction);
        grid.setFocusable(true);
        this.window.add(grid);
        this.window.setVisible(true);
    }

}
