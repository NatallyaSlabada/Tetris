package com.example.javaTetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.text.SimpleDateFormat;

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
        int figureXtemp = game.figure.figureX;
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
            System.out.println("Начало вращения, возможно? " + game.figure.isRotationPossible);
            game.bufferFigure = game.currentFigure;
            //game.temp = game.currentFigure;
            game.figure.rotationNumber++;
            System.out.println("Начало вращения game.figure.figureX " + game.figure.figureX);
            if (game.figure.rotationNumber<game.figure.numberOfPossibleRotations){
                game.currentFigure = game.figure.figureSamples[game.figure.figureID][game.figure.rotationNumber];
                //System.out.println("вращаем до проверки if " + game.figure.rotationNumber);
            }
            else {
                game.figure.rotationNumber = 0;
                game.currentFigure = game.figure.figureSamples[game.figure.figureID][game.figure.rotationNumber];
                //System.out.println("вращаем до проверки else "+ game.figure.rotationNumber);
            }
            if (game.figure.figureX>6){
                game.figure.figureX=6;
                System.out.println("возвращаем в 6 figureX " + game.figure.figureX);
                game.step(game.figure.figureX, game.figure.figureY, Move.ROTATION);
            }
            else game.step(game.figure.figureX, game.figure.figureY, Move.ROTATION);

            if (!game.figure.isRotationPossible){
                game.figure.figureX=figureXtemp;
                game.figure.rotationNumber--;
                System.out.println("вращение не возможно, реверт figureX " + game.figure.figureX);
                game.currentFigure = game.bufferFigure;
                game.step(game.figure.figureX, game.figure.figureY, Move.ROTATION);
               // System.out.println("меняем на буферную фигурку");
            }
            else {
                game.figure.isReachedRightBorder = false;
                //System.out.println("вращение прошло после проверки");
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
