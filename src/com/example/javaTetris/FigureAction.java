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

    @Override
    public void keyPressed(KeyEvent e) {
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
        isLeftRightMovementPossible=true;
        isRotationPossible=true;
    }
    private void move (Move moveDirection){
        int figureXtemp = figureX;
        int figureYtemp = figureY;
        if (moveDirection==Move.LEFT){
            if (figureX-1>=0){
                figureX--;
                isReachedRightBorder = false;
                gridCellsDelegate.step(Move.LEFT);
                if (!isLeftRightMovementPossible){
                    figureX++;
                    gridCellsDelegate.step(Move.LEFT);
                }
                gameDelegate.repaintGrid();
            }
        }
        else if (moveDirection==Move.RIGHT){
            if (!isReachedRightBorder){
                figureX++;
                gridCellsDelegate.step(Move.RIGHT);
                if (!isLeftRightMovementPossible){
                    figureX--;
                    gridCellsDelegate.step(Move.RIGHT);
                }
                gameDelegate.repaintGrid();
            }
        }
        else if (moveDirection==Move.ROTATION){
            if (!isReachedBottomBorder){
                rotate();
                if ((10-figureX)<(getFigureArray()[0].length)){
                    figureX=10-getFigureArray()[0].length;
                    gridCellsDelegate.step(Move.ROTATION);
                }
                else if ((20-figureY)<(getFigureArray().length)){
                    figureY=20-getFigureArray().length;
                    gridCellsDelegate.step(Move.ROTATION);
                }
                else {
                    for (int counter=0; counter<4; counter++){
                        if((figureX-counter)>0){
                            figureX=figureX-counter;
                        }
                        gridCellsDelegate.step(Move.ROTATION);
                        if (isRotationPossible){
                            break;
                        }
                        else {
                            if (counter!=3)isRotationPossible = true;
                        }
                        figureX=figureXtemp;
                    }
                }
                if (!isRotationPossible){
                    figureX=figureXtemp;
                    figureY=figureYtemp;
                    rotateReverse();
                    gridCellsDelegate.step(Move.ROTATION);
                }
                else {
                    isReachedRightBorder = false;
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
