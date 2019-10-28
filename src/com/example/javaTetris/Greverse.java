package com.example.javaTetris;

public class Greverse extends Figure{
    private Greverse() {
        RotationState state1 = new RotationState();
        RotationState state2 = new RotationState();
        state1.figureArray = new int[][] {
                new int[]{0, -1, -1},
                new int[]{-1, -1, 0}
        };
        state2.figureArray = new int[][] {
                new int[]{-1, 0},
                new int[]{-1, -1},
                new int[]{0, -1},
        };
        state1.next = state2;
        state2.next = state1;
        currentState = state1;
        figureColorIndex = 3;
    }

    private static Greverse ourInstance = new Greverse();
    public static Greverse getGreverse() {
        return ourInstance;
    }
}
