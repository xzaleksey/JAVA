package net.wikijava.chapter14;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Компилируется, но приводит к ClassCastException:
        //! gia = (Generic<Integer>[])new Object[SIZE];
        // Тип времени выполнения является "стертым" type:
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
        System.out.println(gia);
        //! gia[1] = new Object(); // Ошибка компиляции
        // Обнаруживается несоответствие типов во время компиляции:
        //! gia[2] = new Generic<Double>();
    }
}
