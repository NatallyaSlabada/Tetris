package com.example.javaTetris;

public class Stick extends Figure{
    private Stick() {
        RotationState state1 = new RotationState();
        RotationState state2 = new RotationState();
        state1.figureArray = new int[][] {
                new int[]{-1,-1,-1,-1}
        };
        state2.figureArray = new int[][] {
                new int[]{-1},
                new int[]{-1},
                new int[]{-1},
                new int[]{-1},
        };
        state1.next = state2;
        state2.next = state1;
        currentState = state1;
        figureColorIndex = 0;
    }
    private static Stick ourInstance = new Stick();
    public static Stick getStick() {
        return ourInstance;
    }

}
