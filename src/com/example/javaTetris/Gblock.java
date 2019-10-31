package com.example.javaTetris;

public class Gblock extends Figure{
    private Gblock() {
        RotationState state1 = new RotationState();
        RotationState state2 = new RotationState();
        state1.figureArray = new int[][] {
                new int[]{-1, -1, 0},
                new int[]{0, -1, -1}
        };
        state2.figureArray = new int[][] {
                new int[]{0, -1},
                new int[]{-1, -1},
                new int[]{-1, 0},
        };
        state1.next = state2;
        state2.next = state1;
        state2.previous = state1;
        state1.previous = state2;
        currentState = state1;
        figureColorIndex = 2;
        figureX = 3;
        states.add(state1);
        states.add(state2);
    }
    @Override
    public void resetFigureData() {
        super.resetFigureData();
        currentState = states.get(0);
        figureX = 3;
    }

    private static Gblock ourInstance = new Gblock();
    public static Gblock getGblock() {
        return ourInstance;
    }
}
