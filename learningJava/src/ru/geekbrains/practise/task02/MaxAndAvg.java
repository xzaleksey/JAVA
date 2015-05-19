package ru.geekbrains.practise.task02;

/**
 * Created by Алексей on 17.05.2015.
 */
public class MaxAndAvg {
    public static void main(String[] args) {
        double[] doubles = new double[]{1, 2, 3, 4, 5, 3.5};
        System.out.println(max(doubles));
        System.out.println(avg(doubles));
    }

    static double max(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        return max;
    }

    static double avg(double[] arr) {
        double avg = 0;
        for (double v : arr) {
            avg += v;
        }
        return avg / arr.length;
    }
}
