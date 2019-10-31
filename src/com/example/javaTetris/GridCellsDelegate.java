package com.example.javaTetris;

public interface GridCellsDelegate {
    /*void step(Move moveDirection);
    public void setFigureY(int figureY);
    public int getFigureY ();
    public void figureSetLanded (boolean isLanded);
    public boolean figureGetLanded ();
    public boolean figureGetDownMovementPossible();
    public boolean figureGetReachedBottomBorder();*/

    public boolean figureGetLanded ();
    void step(Move moveDirection);
    public Figure getFigure();
}
