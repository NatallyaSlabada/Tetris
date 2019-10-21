package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Game {
    public Game() {

    }
    Object[] dialogOptions = {"Restart", "Finish"};
    int score = 130;
    boolean isGameOver = false;
    int speed;
    int accelerationSpeed=70;
    int speedBuffer;
    JFrame window;
    GridCells grid;
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
                    if(grid.gridStable[y + figure.figureY][x + figure.figureX]!=1){
                        grid.gridMovement[y + figure.figureY][x + figure.figureX] = 1;
                    }
                    else {
                        isGameOver = true;
                    }
                }
            }
        }
    }

    public void cleanGridMovement (){
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                grid.gridMovement[y][x] = 0;
            }
        }
    }

    public void step(int figureX, int figureY, Move moveDirection) {
        cleanGridMovement();
        //System.out.println("Beginning of step: "+Thread.currentThread().getName()+" Time:"+ new SimpleDateFormat("ss.SSS").format(new Date()));
       for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (this.currentFigure[y][x] == 1) {
                    if(grid.gridStable[y + figureY][x + figureX]!=1){
                        //System.out.println(Thread.currentThread().getName()+" "+(y + figureY)+" "+(x + figureX) +" Time:"+ new SimpleDateFormat("ss.SSS").format(new Date()));
                        grid.gridMovement[y + figureY][x + figureX] = 1;
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
                int boundCell = this.currentFigure[y][x]+grid.gridStable[y + figureY][x + figureX];
                switch (boundCell){
                    case -1:{
                        figure.isReachedBottomBorder = true;
                        break;
                    }
                    case -3:{
                        figure.isReachedRightBorder = true;
                    }
                }
            }
        }
        //System.out.println("Ending of step: "+Thread.currentThread().getName()+" Time:"+ new SimpleDateFormat("ss.SSS").format(new Date()));
    }

    public void removeFilledLines (){
        for (int y=0; y<20; y++){
            int sum = 0;
            for(int x: grid.gridStable[y]){
                sum+=x;
            }
            if (sum==10){
                score += 10;
               for (int line = y; line>0; line--){
                   grid.gridStable[line]= Arrays.copyOf(grid.gridStable[line-1],13);
               }
                grid.gridStable[0] = new int[]{0,0,0,0,0,0,0,0,0,-4,0,0,0};
               for (int x=0; x<10; x++ ){
                   if (grid.gridStable[19][x]==0||grid.gridStable[19][x]==-4){
                       grid.gridStable[19][x]=-2;
                   }
               }
                if (speed>10){
                    speed = speedBuffer -= 10;
                }
            }
        }
    }

    public void toStableGrid (int figureX, int figureY){
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (this.currentFigure[y][x] == 1) {
                    grid.gridStable[y + figureY][x + figureX] = 1;
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
        this.window.getContentPane().setBackground(Color.BLACK);
        this.grid = new GridCells();
        grid.addKeyListener(figureAction);
        grid.setFocusable(true);
        this.window.add(grid);
        this.window.setVisible(true);
    }

}
