package com.javable.lessons.lesson7;

/**
 * Created by ruaval on 07.04.2015.
 */
public class Derived extends Base {

    String name = "";

    public Derived(String name, long par) {
        super(par);   // ����� ������������ Base(long y)
        this.name = name;
    }

    public long g(int r) {
        return r + super.f();   // ����� ������ f() ������ Base
    }

    public long f() {
        x++;
        return 2 * y;
    }
}

