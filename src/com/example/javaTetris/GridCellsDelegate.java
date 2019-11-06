package com.example.javaTetris;

public interface GridCellsDelegate {
    boolean step(Move moveDirection);
    Figure getFigure();
}
