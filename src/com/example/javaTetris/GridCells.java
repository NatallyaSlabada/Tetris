package com.example.javaTetris;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GridCells extends JComponent {
    public GridCells () {
        for (int x=0; x<10; x++){
            gridStable[19][x]=-2;
        }
        for (int y=0; y<19; y++){
            gridStable[y][9]=-4;
        }
    }
    //Rectangle2D[][] grid = new Rectangle2D[10][20];
    public int[][] gridMovement = new int[20][10];
    public int[][] gridStable = new int[23][13];

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        //int x = 10;
        //int y = 20;
        /*for (int y = 0; y < 600;) {
            for (int x = 0; x < 300;) {
                Rectangle2D rect = new Rectangle(x,y,30,30);
                g2.setColor(Color.GRAY);
                g2.draw(rect);
                x+=30;
            }
            y+=30;
        }*/

        for (int y = 0; y < 600;) {
            for (int x = 0; x < 300;) {
                if (gridStable[y/30][x/30]==1){
                    Rectangle2D rect = new Rectangle(x,y,30,30);
                    g2.setColor(Color.GRAY);
                    g2.fill(rect);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect);
                }
                x+=30;
            }
            y+=30;
        }

        for (int y = 0; y < 600;) {
            for (int x = 0; x < 300;) {
                if (gridMovement[y/30][x/30]==1){
                    Rectangle2D rect = new Rectangle(x,y,30,30);
                    g2.setColor(Color.GRAY);
                    g2.fill(rect);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect);
                }
                x+=30;
            }
            y+=30;
        }
    }
}