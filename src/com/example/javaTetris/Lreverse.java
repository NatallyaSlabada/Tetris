package com.example.javaTetris;

public class Lreverse extends Figure {
    private int defaultY;
    private Lreverse() {
        RotationState state1 = new RotationState();
        RotationState state2 = new RotationState();
        RotationState state3 = new RotationState();
        RotationState state4 = new RotationState();
        state1.figureArray = new int[][] {
                new int[]{-1, 0, 0},
                new int[]{-1, -1, -1}
        };
        defaultY = state1.figureArray.length-1;
        state2.figureArray = new int[][] {
                new int[]{-1, -1},
                new int[]{-1, 0},
                new int[]{-1, 0}
        };
        state3.figureArray = new int[][] {
                new int[]{-1, -1, -1},
                new int[]{0, 0, -1}
        };
        state4.figureArray = new int[][] {
                new int[]{0, -1},
                new int[]{0, -1},
                new int[]{-1, -1}
        };
        state1.next = state2;
        state2.next = state3;
        state3.next = state4;
        state4.next = state1;
        state1.previous = state4;
        state2.previous = state1;
        state3.previous = state2;
        state4.previous = state3;
        currentState = state1;
        figureColorIndex = 5;
        figureX = 4;
        figureY = defaultY;
        defaultState = state1;
    }
    @Override
    public void resetFigureData() {
        super.resetFigureData();
        currentState = defaultState;
        figureX = 4;
        figureY = defaultY;
    }

    private static Lreverse ourInstance = new Lreverse();
    public static Lreverse getLreverse() {
        return ourInstance;
    }
}
