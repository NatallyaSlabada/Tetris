package com.example.javaTetris;

import java.util.ArrayList;

public class Stick extends Figure{
    private int defaultY;
    private Stick() {
        RotationState state1 = new RotationState();
        RotationState state2 = new RotationState();
        state1.figureArray = new int[][] {
                new int[]{-1,-1,-1,-1}
        };
        defaultY = state1.figureArray.length-1;
        state2.figureArray = new int[][] {
                new int[]{-1},
                new int[]{-1},
                new int[]{-1},
                new int[]{-1},
        };
        state1.next = state2;
        state2.next = state1;
        state2.previous = state1;
        state1.previous = state2;
        currentState = state1;
        figureColorIndex = 7;
        figureX = 3;
        figureY = defaultY;
        defaultState = state1;
    }

    @Override
    public void resetFigureData() {
        super.resetFigureData();
        currentState = defaultState;
        figureX = 3;
        figureY = defaultY;
    }

    private static Stick ourInstance = new Stick();
    public static Stick getStick() {
        return ourInstance;
    }

}
