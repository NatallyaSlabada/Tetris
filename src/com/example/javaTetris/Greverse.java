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
        state2.previous = state1;
        state1.previous = state2;
        currentState = state1;
        figureColorIndex = 3;
        figureX = 4;
        states.add(state1);
        states.add(state2);
    }
    @Override
    public void resetFigureData() {
        super.resetFigureData();
        currentState = states.get(0);
        figureX = 4;
    }

    private static Greverse ourInstance = new Greverse();
    public static Greverse getGreverse() {
        return ourInstance;
    }
}
