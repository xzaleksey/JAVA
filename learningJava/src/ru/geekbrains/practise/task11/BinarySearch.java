package ru.geekbrains.practise.task11;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(binarySearch(a, -1));
        Arrays.binarySearch(a, 4);
    }

    public static int binarySearch(int[] arr, int value)

    {
        if (arr.length == 0 || arr[0] > value || arr[arr.length - 1] < value) {
            return -1;
        } else if (arr[0] == value) {
            return arr[0];
        } else if (arr[arr.length - 1] == value) {
            return arr.length - 1;
        }

        return binarySearch(arr, value, 0, arr.length - 1);
    }

    static int binarySearch(int[] arr, int value, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        if (value < arr[mid]) {
            return binarySearch(arr, value, lo, mid - 1);
        } else if (value > arr[mid]) {
            return binarySearch(arr, value, mid + 1, hi);
        } else {
            return mid;
        }

    }

}
