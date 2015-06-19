package net.wikijava.chapter15;

import java.util.Arrays;

public class ThreeDWithNew {
    public static void main(String[] args) {
        // 3-D array with fixed length:
        int[][][] a = new int[2][3][4];
        a[1][1][1] = 5;
        a[0][0][3] = 5;
        System.out.println(Arrays.deepToString(a));
    }
}
