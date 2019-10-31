package com.example.javaTetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FigureAction extends Figure implements KeyListener {
    GridCellsDelegate gridCellsDelegate;
    GameDelegate gameDelegate;
    public FigureAction(GridCells gridCells, Game game) {
        gridCellsDelegate = gridCells;
        gameDelegate = game;
    }
    Figure figure;
    @Override
    public void keyPressed(KeyEvent e) {
        figure = gridCellsDelegate.getFigure();
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case (KeyEvent.VK_RIGHT): {
                move(Move.RIGHT);
                break;
            }
            case (KeyEvent.VK_LEFT): {
                move(Move.LEFT);
                break;
            }
            case (KeyEvent.VK_DOWN): {
                gameDelegate.setSpeed(gameDelegate.getAccelerationSpeed());
                break;
            }
            case (KeyEvent.VK_UP): {
                move(Move.ROTATION);
                break;
            }
        }
        figure.isLeftRightMovementPossible=true;
        figure.isRotationPossible=true;
    }
    private void move (Move moveDirection){
        figure = gridCellsDelegate.getFigure();
        int figureXtemp = figure.figureX;
        int figureYtemp = figure.figureY;
        if (moveDirection==Move.LEFT){
            if (figure.figureX-1>=0){
                figure.figureX--;
                figure.isReachedRightBorder = false;
                gridCellsDelegate.step(Move.LEFT);
                if (!figure.isLeftRightMovementPossible){
                    figure.figureX++;
                    gridCellsDelegate.step(Move.LEFT);
                }
                gameDelegate.repaintGrid();
            }
        }
        else if (moveDirection==Move.RIGHT){
            if (!figure.isReachedRightBorder){
                figure.figureX++;
                gridCellsDelegate.step(Move.RIGHT);
                if (!figure.isLeftRightMovementPossible){
                    figure.figureX--;
                    gridCellsDelegate.step(Move.RIGHT);
                }
                gameDelegate.repaintGrid();
            }
        }
        else if (moveDirection==Move.ROTATION){
            if (!figure.isReachedBottomBorder){
                figure.rotate();
                if ((10-figure.figureX)<(figure.getFigureArray()[0].length)){
                    figure.figureX=10-figure.getFigureArray()[0].length;
                    gridCellsDelegate.step(Move.ROTATION);
                }
                else if ((20-figure.figureY)<(figure.getFigureArray().length)){
                    figure.figureY=20-figure.getFigureArray().length;
                    gridCellsDelegate.step(Move.ROTATION);
                }
                else {
                    for (int counter=0; counter<4; counter++){
                        if((figure.figureX-counter)>0){
                            figure.figureX=figure.figureX-counter;
                        }
                        gridCellsDelegate.step(Move.ROTATION);
                        if (figure.isRotationPossible){
                            break;
                        }
                        else {
                            if (counter!=3)figure.isRotationPossible = true;
                        }
                        figure.figureX=figureXtemp;
                    }
                }
                if (!figure.isRotationPossible){
                    figure.figureX=figureXtemp;
                    figure.figureY=figureYtemp;
                    figure.rotateReverse();
                    gridCellsDelegate.step(Move.ROTATION);
                }
                else {
                    figure.isReachedRightBorder = false;
                }
                gameDelegate.repaintGrid();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode==KeyEvent.VK_DOWN){
            gameDelegate.setSpeed(gameDelegate.getSpeedBuffer());
        }
    }
}
