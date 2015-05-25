package ru.geekbrains.practise.task05;

import java.util.Arrays;

public class LongestSequence {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 1, 3, 1, 2, 6, 7, 8, 9, 10, 11, 0, -1};
        int counter = 0, previous = Integer.MIN_VALUE, maxSequence = 0, start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > previous) {
                counter++;
            } else {
                if (maxSequence < counter) {
                    maxSequence = counter;
                    start = i - counter;
                }
                counter = 1;
            }
            if (i == arr.length - 1) {
                if (maxSequence < counter) {
                    maxSequence = counter;
                    start = i + 1 - counter;
                }
            } else {
                previous = arr[i];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, start, start + maxSequence)));
    }
}
