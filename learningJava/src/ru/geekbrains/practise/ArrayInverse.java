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
        int len = ints.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = ints[i];
            ints[i] = ints[len - 1 - i];
            ints[len - 1 - i] = temp;

        }
        return ints;
    }
}
