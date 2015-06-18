package net.wikijava.chapter14.generic;

import java.util.Arrays;

public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai =
                new GenericArray<>(10);
        gai.put(1, 5);
        // Приводит к ClassCastException:
        //! Integer[] ia = gai.rep();
        // А так можно
        System.out.println(Arrays.toString(gai.rep()));
        Object[] oa = gai.rep();

    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Метод, предоставляющий доступ к базовому представлению:
    public T[] rep() {
        return array;
    }
}