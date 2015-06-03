package net.wikijava.chapter14;

public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    public static void main(String[] args) {
        TwoTuple<Integer, Integer> twoTuple = new TwoTuple<>(1, 2);
        System.out.println(twoTuple);
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
