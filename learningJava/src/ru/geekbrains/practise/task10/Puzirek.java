package ru.geekbrains.practise.task10;

import java.util.Arrays;

public class Puzirek {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 5, 2, 7, 5};
        System.out.println(Arrays.toString(sort(arr)));
    }

    static int[] sort(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }

        return arr;
    }
}
