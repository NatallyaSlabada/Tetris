package com.example.javaTetris;

public class Cube extends Figure {
    private Cube() {
        RotationState state1 = new RotationState();
        state1.figureArray = new int[][] {
                new int[]{-1,-1},
                new int[]{-1,-1}
        };
        state1.next = state1;
        currentState = state1;
    }

    private static Cube ourInstance = new Cube();
    public static Cube getCube() {
        return ourInstance;
    }
}
