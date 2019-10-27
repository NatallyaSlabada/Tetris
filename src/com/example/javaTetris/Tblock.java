package com.example.javaTetris;

public class Tblock extends Figure {
    private Tblock() {
        RotationState state1 = new RotationState();
        RotationState state2 = new RotationState();
        RotationState state3 = new RotationState();
        RotationState state4 = new RotationState();
        state1.figureArray = new int[][] {
                new int[]{0, -1, 0},
                new int[]{-1, -1, -1}
        };
        state2.figureArray = new int[][] {
                new int[]{-1, 0},
                new int[]{-1, -1},
                new int[]{-1, 0}
        };
        state3.figureArray = new int[][] {
                new int[]{-1, -1, -1},
                new int[]{0, -1, 0}
        };
        state4.figureArray = new int[][] {
                new int[]{0, -1},
                new int[]{-1, -1},
                new int[]{0, -1}
        };
        state1.next = state2;
        state2.next = state3;
        state3.next = state4;
        state4.next = state1;
        currentState = state1;
    }

    private static Tblock ourInstance = new Tblock();
    public static Tblock getTblock() {
        return ourInstance;
    }
}