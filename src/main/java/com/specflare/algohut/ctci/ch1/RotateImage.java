package com.specflare.algohut.ctci.ch1;

// Given an image represented as a MxN matrix, rotate it 90 degrees to the right.
public class RotateImage {
    public static void rotateImage(short[][] img) {
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                img[i][j] = img[2 - j][i];
            }
        }
    }
}
