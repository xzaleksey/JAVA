package ru.geekbrains.practise.task05;

public class LongestSequence {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 1, 3, 1, 2, 6, 7, 8, 9, 10, 11, 0, -1};
        int counter = 1, max = Integer.MIN_VALUE, maxSequence = 0;
        for (int i : arr) {
            if (i > max) {
                counter++;
            } else {
                maxSequence = maxSequence > counter ? maxSequence : counter;
                counter = 1;
            }
            max = i;
        }
        System.out.println(maxSequence);
    }
}
