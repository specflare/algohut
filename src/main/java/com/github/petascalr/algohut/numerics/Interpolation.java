package com.github.petascalr.algohut.numerics;

public class Interpolation {
    public static float linearInterpolation(float[] X, float[] Y, float xVal) {
        assert(X.length == Y.length);

        for (int i = 0; i < X.length - 1; ++i) {
            if (X[i] <= xVal && xVal < X[i + 1]) {
                return Y[i] + (xVal - X[i]) * (Y[i + 1] - Y[i]) / (X[i + 1] - X[i]);
            }
        }

        return 0.0f;
    }

    public static float[] linearInterpolation(float[] X, float[] Y, float[] xVals) {
        float[] yVals = new float[xVals.length];
        for (int i = 0; i < xVals.length; ++i) {
            yVals[i] = linearInterpolation(X, Y, xVals[i]);
        }

        return yVals;
    }
}
