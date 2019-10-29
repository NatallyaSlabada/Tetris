package com.example.javaTetris;

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
    RotationState currentState;
    int figureColorIndex;

    public void setFigureY(int figureY){
        this.figureY=figureY;
    }
    public int getFigureY (){
        return this.figureY;
    }
    public void setLanded (boolean isLanded){
        this.isLanded=isLanded;
    }
    public boolean getLanded (){
        return this.isLanded;
    }
    public boolean getDownMovementPossible(){
        return this.isDownMovementPossible;
    }
    public boolean getReachedBottomBorder(){
        return this.isReachedBottomBorder;
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

}
