package net.wikijava.chapter7;

//: reusing/FinalData.java
// Действие ключевого слова final для полей.

import java.util.Random;

import static net.mindview.util.Print.print;


class Value {
    int i; // доступ в пределах пакета

    public Value(int i) {
        this.i = i;
    }
}

public class FinalData {
    // Типичная открытая константа:
    public static final int VALUE_THREE = 39;
    private static final int VALUE_TWO = 99;
    private static final Value VAL_3 = new Value(33);
    private static Random rand = new Random(47);
    static final int INT_5 = rand.nextInt(20);
    // Могут быть константами времени компиляции:
    private final int valueOne = 9;
    // He может быть константой времени компиляции:
    private final int i4 = rand.nextInt(20);
    private final Value v2 = new Value(22);
    // Массивы:
    private final int[] a = {1, 2, 3, 4, 5, 6};
    private String id;
    private Value v1 = new Value(11);

    public FinalData(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        //! fd1.valueOne++; // Ошибка значение нельзя изменить
        fd1.v2.i++; // Объект не является неизменным!
        fd1.v1 = new Value(9); // OK - не является неизменным
        for (int i = 0; i < fd1.a.length; i++)
            fd1.a[i]++;  // Объект не является неизменным!
        //! fd1.v2 = new Value(0); // Ошибка: ссылку
        //! fd1.VAL_3 = new Value(1); // нельзя изменить
        //! fd1.a = new int[3];
        print(fd1);
        print("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        print(fd1);
        print(fd2);
    }

    public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }
}