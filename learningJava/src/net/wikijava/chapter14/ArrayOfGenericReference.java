package net.wikijava.chapter14;

class Generic<T> {
}

public class ArrayOfGenericReference {
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        System.out.println(gia);
    }
}
