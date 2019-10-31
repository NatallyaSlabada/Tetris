package com.example.javaTetris;

import java.util.Random;

public class FigureFactory {
    private static int figureID;
    private static Random random = new Random();

    public static Figure getNewFigure() {
        return Cube.getCube();
        /*figureID = random.nextInt(7);
        switch (figureID) {
            case 0:{
                return Stick.getStick();
            }
            case 1:{
                return Cube.getCube();
            }
            case 2:{
                return Tblock.getTblock();
            }
            case 3:{
                return Lblock.getLblock();
            }
            case 4:{
                return Lreverse.getLreverse();
            }
            case 5:{
                return Gblock.getGblock();
            }
            case 6:{
                return Greverse.getGreverse();
            }
            default:{
                return Stick.getStick();
            }
        }*/
    }
}
