package ru.geekbrains.practise.task09;

import java.util.Arrays;
import java.util.Random;

public class Sum {
    public static void main(String[] args) {
        Random rand = new Random();
        int a[] = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            a[i] = rand.nextInt(500);
        }
        int s = rand.nextInt(200) + 1;
        Arrays.sort(a);
        //  System.out.println(Arrays.toString(a));
        System.out.println(s);
        long timestart = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            int index = binarySearch(a, s - a[i], i);
            if (index != -1) {
                System.out.println(i + " " + a[i] + "\n" + index + " " + a[index]);
                break;
            }
        }
        long timeend = System.currentTimeMillis();
        System.out.println(((timeend - timestart) / 1000.));
    }

    static int binarySearch(int[] arr, int value, int index) {
        return binarySearch(arr, value, 0, arr.length - 1, index);
    }

    static int binarySearch(int[] arr, int value, int lo, int hi, int index) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (mid == index) {
            if (arr[mid - 1] == value) {
                return mid - 1;
            } else if (arr[mid + 1] == value) {
                return mid + 1;
            } else return -1;
        } else {
            if (value < arr[mid]) {
                return binarySearch(arr, value, lo, mid - 1, index);
            } else if (value > arr[mid]) {
                return binarySearch(arr, value, mid + 1, hi, index);
            } else {
                return mid;
            }
        }
    }

}
