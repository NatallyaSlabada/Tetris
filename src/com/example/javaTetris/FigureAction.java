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
                game.figure.figureX+=1;
                if (game.figure.figureX<=6){
                    game.step(game.figure.figureX, game.figure.figureY, game.figure);
                    if (!game.figure.isLeftRightMovementPossible){
                        game.figure.figureX--;
                        game.step(game.figure.figureX, game.figure.figureY, game.figure);
                    }
                    game.window.repaint();
                }
                else game.figure.figureX-=1;
                break;
            }
            case (KeyEvent.VK_LEFT): {
                game.figure.figureX-=1;
                if (game.figure.figureX>=0){
                    game.step(game.figure.figureX, game.figure.figureY, game.figure);
                    if (!game.figure.isLeftRightMovementPossible){
                        game.figure.figureX++;
                        game.step(game.figure.figureX, game.figure.figureY, game.figure);
                    }
                    game.window.repaint();
                }
                else game.figure.figureX+=1;
                break;
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
