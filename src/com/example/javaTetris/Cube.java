package com.example.javaTetris;

public class Cube extends Figure {
    private Cube() {
        RotationState state1 = new RotationState();
        state1.figureArray = new int[][] {
                new int[]{-1,-1},
                new int[]{-1,-1}
        };
        state1.next = state1;
        state1.previous = state1;
        currentState = state1;
        figureColorIndex = 1;
        figureX = 4;
        states.add(state1);
    }
    @Override
    public void resetFigureData() {
        super.resetFigureData();
        currentState = states.get(0);
        figureX = 4;
    }

    private static Cube ourInstance = new Cube();
    public static Cube getCube() {
        return ourInstance;
    }
}
