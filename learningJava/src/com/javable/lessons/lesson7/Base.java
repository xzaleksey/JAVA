package com.javable.lessons.lesson7;

/**
 * Created by ruaval on 07.04.2015.
 */
class Base {
    int x = 1;
    long y;

    Base(long y) {
        this.y = y;
    }

    Base() {
        this(0);   // ����� ������������ Base(long y)
    }

    public long f() {
        return x * y;
    }
}

