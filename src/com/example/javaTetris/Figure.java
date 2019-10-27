package com.example.javaTetris;

import java.awt.*;
import java.util.Random;

public abstract class Figure {
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
    public void rotate (){
        currentState = currentState.next;
    }
    public int[][] getFigureArray(){
        return currentState.figureArray;
    }

}
