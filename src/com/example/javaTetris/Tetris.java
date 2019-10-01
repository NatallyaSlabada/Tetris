package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tetris {
    public static void main(String[] args) {
        Game game = new Game();
        game.setWindow();
        game.currentFigure = game.getNewFigure();
        game.step();

    }
}
