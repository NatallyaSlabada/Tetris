package com.example.javaTetris;

import java.util.ArrayList;

public abstract class Figure {
    //Rectangle rectangle = new Rectangle(30,30);
    int figureX;
    int figureY;
    boolean isLanded = false;
    boolean isDownMovementPossible = true;
    boolean isLeftRightMovementPossible = true;
    boolean isRotationPossible = true;
    boolean isReachedBottomBorder = false;
    boolean isReachedRightBorder = false;
    RotationState currentState;
    protected RotationState defaultState;
    int figureColorIndex;

    public boolean getLanded (){
        return this.isLanded;
    }

    public void rotate (){
        currentState = currentState.next;
    }
    public void rotateReverse() {
        currentState = currentState.previous;
    }
    public int[][] getFigureArray(){
        return currentState.figureArray;
    }
    public void resetFigureData (){
        figureY = 0;
        isLanded = false;
        isDownMovementPossible = true;
        isLeftRightMovementPossible = true;
        isRotationPossible = true;
        isReachedBottomBorder = false;
        isReachedRightBorder = false;
    }

}
