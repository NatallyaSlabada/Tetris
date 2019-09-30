package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;

public class Tetris {
    public static void main(String[] args) {
        //Game game = new Game();
        JFrame window;
        window = new JFrame();
        window.setSize(315,637);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Tetris");
        window.getContentPane().setBackground(Color.CYAN);
        //JPanel panel = new JPanel();
        //window.add(panel);
        JComponent cell = new GridCells();
        window.add(cell);
        window.setVisible(true);
    }
}
