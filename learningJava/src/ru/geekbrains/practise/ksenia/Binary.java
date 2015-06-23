package ru.geekbrains.practise.ksenia;

public class Binary {
    public static void main(String[] args) {
        int value = 1;
        int[] mas = new int[]{1, 1};
        Binary binary = new Binary();
        int index = binary.search(value, mas, 0, mas.length - 1);
        System.out.println(value + " equals " + index);
    }

    public int search(double value, int[] mas, int lowValue, int highValue) {
        if (highValue < lowValue) return -1;
        int mid = (lowValue + highValue) / 2;
        if (value > mas[mid]) {
            return search(value, mas, mid + 1, highValue);
        } else if (value < mas[mid]) {
            return search(value, mas, lowValue, mid - 1);
        } else return mid;
    }
}