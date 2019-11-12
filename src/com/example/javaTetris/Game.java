package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Game implements GameDelegate{
    public Game(int gameSpeed) {
        this.speed=this.speedBuffer=gameSpeed;
    }
    int score = 0;
    boolean isGameOver = false;
    public int speed;
    int accelerationSpeed=70;
    int speedBuffer;
    JFrame window;
    public GridCells gridCells;
    FigureAction figureAction;

    @Override
    public void repaintGrid (){
        this.window.repaint();
    }
    @Override
    public int getAccelerationSpeed(){
        return this.accelerationSpeed;
    }
    @Override
    public int getSpeedBuffer(){
        return this.speedBuffer;
    }
    @Override
    public void setSpeed (int speed){
        this.speed=speed;
    }

    public int getSpeed (){
        return this.speed;
    }

    public void setFigureOnField() {
        isGameOver = !gridCells.setFigureOnField();
    }

    public void updateGrid(){
        gridCells.updateGrid();
    }

    public void removeFilledLines (){
        for (int y=0; y<20; y++){
            boolean nullInLine = false;
            for(int x: gridCells.grid[y]){
                if (x==0){
                    nullInLine = true;
                }
            }
            if (!nullInLine){
                score += 10;
               for (int line = y; line>0; line--){
                   gridCells.grid[line]= Arrays.copyOf(gridCells.grid[line-1],10);
               }
                gridCells.grid[0] = new int[]{0,0,0,0,0,0,0,0,0,0};
                if (speed>150){
                    speed = speedBuffer -= 10;
                }
            }
        }
    }

    public void setWindow() {
        this.window = new JFrame();
        this.window.setSize(315, 637);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setTitle("Tetris");
        this.window.getContentPane().setBackground(Color.BLACK);
        this.gridCells = new GridCells();
        this.figureAction = new FigureAction(this.gridCells, this);
        gridCells.addKeyListener(figureAction);
        gridCells.setFocusable(true);
        this.window.add(gridCells);
        this.window.setVisible(true);
    }

}
