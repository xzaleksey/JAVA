package com.javable.lessons.lesson7;

/**
 * Created by ruaval on 07.04.2015.
 */
public class Derived extends Base {

    String name = "";

    public Derived(String name, long par) {
        super(par);   // вызов конструктора Base(long y)
        this.name = name;
    }

    public long g(int r) {
        return r + super.f();   // вызов метода f() класса Base
    }

    public long f() {
        x++;
        return 2 * y;
    }
}

