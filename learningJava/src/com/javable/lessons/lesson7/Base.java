package com.javable.lessons.lesson7;

/**
 * Created by ruaval on 07.04.2015.
 */

//базовый класс
public class Base {
    int x = 1;
    long y;

    Base(long y) {
        this.y = y;
    }

    Base() {
        this(0);   // вызов конструктора Base(long y)
    }

    public long f() {
        return x * y;
    }
}

