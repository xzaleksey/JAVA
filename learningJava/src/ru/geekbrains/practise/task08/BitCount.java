package ru.geekbrains.practise.task08;

public class BitCount {
    public static void main(String[] args) {
        System.out.println(numOnes(7));
    }

    static int numOnes(int x) {
        char[] binary = Integer.toBinaryString(x).toCharArray();
        int count = 0;
        for (char c : binary) {
            count += Character.getNumericValue(c) == 1 ? 1 : 0;
        }
        return count;
    }
}
