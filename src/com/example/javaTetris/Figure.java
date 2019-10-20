package com.example.javaTetris;

import java.awt.*;
import java.util.Random;

public class Figure {
    //Rectangle rectangle = new Rectangle(30,30);
    int figureX = 3;
    int figureY = 0;
    int figureID;
    int numberOfPossibleRotations;
    int rotationNumber = 0;
    boolean isLanded = false;
    boolean isDownMovementPossible = true;
    boolean isLeftRightMovementPossible = true;
    boolean isRotationPossible = true;
    boolean isReachedBottomBorder = false;
    boolean isReachedRightBorder = false;

    int[][][][] figureSamples = {
            {
                    {
                            {1,1,1,1}, // XXXX
                            {0,0,0,0},
                            {0,0,0,0},
                            {0,0,0,0}
                    },
                    {
                            {1,0,0,0}, // X
                            {1,0,0,0}, // X
                            {1,0,0,0}, // X
                            {1,0,0,0}  // X
                    }
            },
            {
                    {
                            {1,0,0,0}, // X
                            {1,1,1,0}, // XXX
                            {0,0,0,0},
                            {0,0,0,0}
                    },
                    {
                            {1,1,0,0}, // XX
                            {1,0,0,0}, // X
                            {1,0,0,0}, // X
                            {0,0,0,0}
                    },
                    {
                            {1,1,1,0}, // XXX
                            {0,0,1,0}, //   X
                            {0,0,0,0},
                            {0,0,0,0}
                    },
                    {
                            {0,1,0,0}, //  X
                            {0,1,0,0}, //  X
                            {1,1,0,0}, // XX
                            {0,0,0,0}
                    }
            },
            {
                    {
                            {0,0,1,0}, //    X
                            {1,1,1,0}, //  XXX
                            {0,0,0,0},
                            {0,0,0,0}
                    },
                    {
                            {1,0,0,0}, // X
                            {1,0,0,0}, // X
                            {1,1,0,0}, // XX
                            {0,0,0,0}
                    },
                    {
                            {1,1,1,0}, // XXX
                            {1,0,0,0}, // X
                            {0,0,0,0},
                            {0,0,0,0}
                    },
                    {
                            {1,1,0,0}, // XX
                            {0,1,0,0}, //  X
                            {0,1,0,0}, //  X
                            {0,0,0,0}
                    }
            },
            {
                    {
                            {1,1,0,0}, //  XX
                            {1,1,0,0}, //  XX
                            {0,0,0,0},
                            {0,0,0,0}
                    }
            },
            {
                    {
                            {0,1,0,0}, //  X
                            {1,1,1,0}, // XXX
                            {0,0,0,0},
                            {0,0,0,0}
                    },
                    {
                            {1,0,0,0}, // X
                            {1,1,0,0}, // XX
                            {1,0,0,0}, // X
                            {0,0,0,0}
                    },
                    {
                            {1,1,1,0}, // XXX
                            {0,1,0,0}, //  X
                            {0,0,0,0},
                            {0,0,0,0}
                    },
                    {
                            {0,1,0,0}, //  X
                            {1,1,0,0}, // XX
                            {0,1,0,0}, //  X
                            {0,0,0,0}
                    }
            },
            {
                    {
                            {0,1,1,0}, //  XX
                            {1,1,0,0}, // XX
                            {0,0,0,0},
                            {0,0,0,0}
                    },
                    {
                            {1,0,0,0}, // X
                            {1,1,0,0}, // XX
                            {0,1,0,0}, //  X
                            {0,0,0,0}
                    }
            },
            {
                    {
                            {1,1,0,0}, //  XX
                            {0,1,1,0}, //   XX
                            {0,0,0,0},
                            {0,0,0,0}
                    },
                    {
                            {0,1,0,0}, //  X
                            {1,1,0,0}, // XX
                            {1,0,0,0}, // X
                            {0,0,0,0}
                    }
            }
    };
    public Random random = new Random();
    public int[][] getNewFigure (){
        //random.nextInt(7);
        figureID = random.nextInt(7);
        numberOfPossibleRotations = figureSamples[figureID].length;
        return figureSamples[figureID][0];
    }
}
