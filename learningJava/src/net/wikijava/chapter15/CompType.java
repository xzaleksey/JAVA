package net.wikijava.chapter15;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.Arrays;
import java.util.Random;

import static net.mindview.util.Print.print;

public class CompType implements Comparable<CompType> {
    private static int count = 1;
    private static Random r = new Random(47);
    int i;
    int j;

    public CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a =
                Generated.array(new CompType[12], generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a);
        print("after sorting:");
        print(Arrays.toString(a));
    }

    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0)
            result += "\n";
        return result;
    }

    @Override
    public int compareTo(CompType rv) {
        return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
    }
}
