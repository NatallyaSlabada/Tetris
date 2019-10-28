package com.example.javaTetris;

import java.awt.*;
import java.util.Random;

public abstract class Figure implements FigureDelegate{
    //Rectangle rectangle = new Rectangle(30,30);
    int figureX = 3;
    int figureY = 0;
    int figureID;
    boolean isLanded = false;
    boolean isDownMovementPossible = true;
    boolean isLeftRightMovementPossible = true;
    boolean isRotationPossible = true;
    boolean isReachedBottomBorder = false;
    boolean isReachedRightBorder = false;

    public Figure figure;
    RotationState currentState;
    int figureColorIndex;

    public void rotate (){
        currentState = currentState.next;
    }
    public int[][] getFigureArray(){
        return currentState.figureArray;
    }

    @Override
    public void setFigureX (int figureX){
        this.figureX=figureX;
    }
    @Override
    public int getFigureX (){
        return this.figureX;
    }

}
