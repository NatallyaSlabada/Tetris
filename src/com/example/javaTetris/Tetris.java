package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;

public class Tetris {
    public static void main(String[] args) {
        //Game game = new Game();
        JFrame window;
        window = new JFrame();
        window.setSize(600,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Tetris");
        window.getContentPane().setBackground(Color.CYAN);
        window.setVisible(true);
    }
}
