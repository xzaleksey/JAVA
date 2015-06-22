package net.wikijava.chapter15;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

import static net.mindview.util.Print.print;

public class StringSorting {
    public static void main(String[] args) {
        String[] sa = Generated.array(new String[20],
                new RandomGenerator.String(5));
        print("Before sort: " + Arrays.toString(sa));
        Arrays.sort(sa);
        print("After sort: " + Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        print("Reverse sort: " + Arrays.toString(sa));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        print("Case-insensitive sort: " + Arrays.toString(sa));
    }
}
