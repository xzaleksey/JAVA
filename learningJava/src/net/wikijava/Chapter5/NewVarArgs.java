package net.wikijava.Chapter5;

import com.javable.lessons.lesson8.A;

/**
 * Created by ruaval on 10.04.2015.
 */
public class NewVarArgs {
    static void printArray(Object... args) {// с помощью троеточий указываем, что параметр при вызове 1 и значения помещаются в массив
        for (Object obj : args)
            System.out.print(obj + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // Можно передать отдельные элементы:
        printArray(new Integer(47), new Float(3.14),
                new Double(11.11));
        printArray(47, 3.14F, 11.11);
        printArray("one", "two", "three");
        printArray(new A(), new A(), new A());
        // Или массив:
        printArray((Object[]) new Integer[]{1, 2, 3, 4});
        printArray(); // Пустой список тоже возможен
    }
}
