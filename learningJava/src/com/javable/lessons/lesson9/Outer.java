package com.javable.lessons.lesson9;

/**
 * Created by ruaval on 08.04.2015.
 */
public class Outer {
    int y;

    public Outer(int x) {
        y = x;
    }

    void g(String s) {
        class Inner2 { // Вложенный класс. Размещен внутри метода g класса Outer

        }
        System.out.println("Тут есть класс Inner2");
    }

    public class Inner1 {    // Вложенный класс. Размещен внутри класса Outer
        public int f1() {
            return ++y;
        }

    }

}
