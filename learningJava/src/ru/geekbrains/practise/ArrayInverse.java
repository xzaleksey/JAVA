package ru.geekbrains.practise;

import java.util.Arrays;

/**
 * Created by Алексей on 16.05.2015.
 */
public class ArrayInverse {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arrayInverse(ints)));

    }

    static int[] arrayInverse(int ints[]) {
        for (int i = 0; i < ints.length / 2; i++) {
            int temp = ints[i];
            ints[i] = ints[ints.length - 1 - i];
            ints[ints.length - 1 - i] = temp;

        }
        return ints;
    }
}
