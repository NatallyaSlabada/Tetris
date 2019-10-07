package com.example.javaTetris;

import java.awt.*;
import java.util.Random;

public class Figure {
    //Rectangle rectangle = new Rectangle(30,30);
    int figureX = 3;
    int figureY = 0;
    boolean isLanded = false;
    boolean isMovementPossible = true;
    int[][][] figureSamples = {
            {
                    {1,1,1,1}, // XXXX
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,0,0,0}, // X
                    {1,1,1,0}, // XXX
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {0,0,0,1}, //    X
                    {0,1,1,1}, //  XXX
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {0,1,1,0}, //  XX
                    {0,1,1,0}, //  XX
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {0,1,0,0}, //  X
                    {1,1,1,0}, // XXX
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {0,1,1,0}, //  XX
                    {1,1,0,0}, // XX
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {0,1,1,0}, //  XX
                    {0,0,1,1}, //   XX
                    {0,0,0,0},
                    {0,0,0,0}
            }
    };
    public Random random = new Random();
    public int[][] getNewFigure (){
        return figureSamples[random.nextInt(7)];
    }
}
