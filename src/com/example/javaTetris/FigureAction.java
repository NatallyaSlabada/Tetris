package com.example.javaTetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FigureAction implements KeyListener {
    Game game;

    public FigureAction(Game game) {
        this.game = game;
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
                game.speed = 70;
                break;
            }
            case (KeyEvent.VK_UP): {
                move(Move.ROTATION);
                break;
            }
        }
        game.figure.isLeftRightMovementPossible=true;
        game.figure.isRotationPossible=true;
    }
    protected void move (Move moveDirection){
        if (moveDirection==Move.LEFT){
            game.figure.figureX--;
            if (game.figure.figureX>=0){
                game.figure.isReachedRightBorder = false;
                game.step(game.figure.figureX, game.figure.figureY, Move.LEFT);
                if (!game.figure.isLeftRightMovementPossible){
                    game.figure.figureX++;
                    game.step(game.figure.figureX, game.figure.figureY, Move.LEFT);
                }
                game.window.repaint();
            }
            else game.figure.figureX++;
        }
        else if (moveDirection==Move.RIGHT){
            game.figure.figureX++;
            if (!game.figure.isReachedRightBorder){
                game.step(game.figure.figureX, game.figure.figureY, Move.RIGHT);
                if (!game.figure.isLeftRightMovementPossible){
                    game.figure.figureX--;
                    game.step(game.figure.figureX, game.figure.figureY, Move.RIGHT);
                }
                game.window.repaint();
            }
            else game.figure.figureX--;
        }
        else if (moveDirection==Move.ROTATION){
            game.bufferFigure = game.currentFigure;
            game.figure.rotationNumber++;
            if (game.figure.rotationNumber<game.figure.numberOfPossibleRotations){
                game.currentFigure = game.figure.figureSamples[game.figure.figureID][game.figure.rotationNumber];
            }
            else {
                game.figure.rotationNumber = 0;
                game.currentFigure = game.figure.figureSamples[game.figure.figureID][game.figure.rotationNumber];
            }
            if (game.figure.figureX>6){
                game.figure.figureX=6;
            }
            game.step(game.figure.figureX, game.figure.figureY, Move.ROTATION);
            if (!game.figure.isRotationPossible){
                game.currentFigure = game.bufferFigure;
            }
            else {
                game.figure.isReachedRightBorder = false;
            }
            game.window.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode==KeyEvent.VK_DOWN){
            game.speed = 500;
        }
    }
}
