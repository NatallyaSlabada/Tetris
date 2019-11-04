package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GridCells extends JComponent implements GridCellsDelegate {
    public GridCells () {

    }
    //public int[][] gridMovement = new int[20][10];
    public int[][] grid = new int[20][10];
    Figure figure;
    @Override
    public Figure getFigure(){
        return this.figure;
    }
    @Override
    public boolean figureGetLanded (){
        return figure.getLanded();
    }


    public void updateGrid(){
        //System.out.println("Ending step in Tetris: "+Thread.currentThread().getName()+" Time:"+ new SimpleDateFormat("ss.SSS").format(new Date()));
        //System.out.println("isReachedBottomBorder "+game.figure.isReachedBottomBorder);
        if (!figure.isReachedBottomBorder){
            figure.figureY++;
            if(!step(Move.DOWN)){
                figure.figureY--;
            }
        }
        if (!figure.isDownMovementPossible){
            figure.figureY--;
            step(Move.DOWN);
            figure.isLanded = true;
        }
        if (figure.isReachedBottomBorder){
            figure.isLanded = true;
        }
        if (figure.isLanded){
            System.out.println(figure.figureY);
            int[][] currentFigure = figure.getFigureArray();
            for (int y = 0; y < currentFigure.length; y++) {
                for (int x = 0; x < currentFigure[0].length; x++) {
                    if (currentFigure[y][x] == -1) {
                        grid[y + figure.figureY][x + figure.figureX] = figure.figureColorIndex;
                    }
                }
            }
        }
    }



    public static Figure getNewFigure(){
        return FigureFactory.getNewFigure();
    }

    public boolean setFigureOnField() {
        figure = getNewFigure();
        figure.resetFigureData();
        int[][] currentFigure = figure.getFigureArray();
        for (int y = 0; y < currentFigure.length; y++) {
            for (int x = 0; x < currentFigure[0].length; x++) {
                if (currentFigure[y][x] == -1) {
                    if(grid[y + figure.figureY][x + figure.figureX] == 0){
                        grid[y + figure.figureY][x + figure.figureX] = -1;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void cleanPreviousFigure (){
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if(grid[y][x] == -1){
                    grid[y][x] = 0;
                }
            }
        }
    }

    public boolean step(Move moveDirection) {
        cleanPreviousFigure();
        int[][] currentFigure = figure.getFigureArray();
        //System.out.println("Beginning of step: "+Thread.currentThread().getName()+" Time:"+ new SimpleDateFormat("ss.SSS").format(new Date()));
        for (int y = 0; y < currentFigure.length; y++) {
            for (int x = 0; x < currentFigure[0].length; x++) {
                if((currentFigure.length+figure.figureY)>20){
                    figure.isReachedBottomBorder = true;
                    return false;
                }
                if (currentFigure[y][x] == -1) {
                    if(grid[y + figure.figureY][x + figure.figureX] == 0){
                        //System.out.println(Thread.currentThread().getName()+" "+(y + figureY)+" "+(x + figureX) +" Time:"+ new SimpleDateFormat("ss.SSS").format(new Date()));
                        grid[y + figure.figureY][x + figure.figureX] = -1;
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
                if ((x+figure.figureX)==9){
                    figure.isReachedRightBorder = true;
                }
            }
        }
        //System.out.println("Ending of step: "+Thread.currentThread().getName()+" Time:"+ new SimpleDateFormat("ss.SSS").format(new Date()));
        return true;
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        //int x = 10;
        //int y = 20;
        for (int y = 0; y < 600;) {
            for (int x = 0; x < 300;) {
                Rectangle2D rect = new Rectangle(x,y,30,30);
                g2.setColor(Color.GRAY);
                g2.draw(rect);
                x+=30;
            }
            y+=30;
        }

        for (int y = 0; y < 600;) {
            for (int x = 0; x < 300;) {
                if (grid[y/30][x/30]!=0){
                    Rectangle2D rect = new Rectangle(x,y,30,30);
                    g2.setColor(selectColor(grid[y/30][x/30]));
                    g2.fill(rect);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect);
                }
                x+=30;
            }
            y+=30;
        }
    }

    private Color selectColor(int colorIndex){
        switch (colorIndex){
            case 7:{
                return Color.ORANGE;
            }
            case 1:{
                return Color.BLUE;
            }
            case 2:{
                return Color.CYAN;
            }
            case 3:{
                return Color.RED;
            }
            case 4:{
                return Color.YELLOW;
            }
            case  5:{
                return Color.GREEN;
            }
            case 6:{
                return Color.MAGENTA;
            }
            case -1:{
                return selectColor(figure.figureColorIndex);
            }
            default:{
                return Color.WHITE;
            }
        }
    }
}



    /*@Override
    public void setFigureY(int figureY){
        figure.setFigureY(figureY);
    }
    @Override
    public int getFigureY (){
        return figure.getFigureY();
    }
    @Override
    public void figureSetLanded (boolean isLanded){
        figure.setLanded(isLanded);
    }

    @Override
    public boolean figureGetDownMovementPossible(){
        return figure.isDownMovementPossible;
    }
    @Override
    public boolean figureGetReachedBottomBorder(){
        return figure.isReachedBottomBorder;
    }
*/

