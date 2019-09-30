package com.example.javaTetris;

import java.awt.*;

public class Figure {
    //Rectangle rectangle = new Rectangle(30,30);
    public static int[][][] figereSamples = {
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
    public static int[][] getNewFigure (){
        return figereSamples[(int)Math.random()];
    }
}
