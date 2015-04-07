package com.javable.lessons.lesson7;

/**
 * Created by ruaval on 07.04.2015.
 */
//Наследующий класс
public class Derived extends Base {

    String name = "";


    public Derived() {// 1
        main();
    }

    public Derived(String name, long par) {//3
        super(par);   // вызов конструктора Base(long y)
        this.name = name;
    }

    public static void main() {//2
        Derived d = new Derived("test", 10);
        long c = d.g(5);
        long p = d.f();
        System.out.println(c);
        System.out.println(p);
    }

    public long g(int r) {
        return r + super.f();   // вызов метода f() класса Base
    }

    public long f() {
        x++;
        return 2 * y;
    }
}

