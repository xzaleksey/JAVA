package com.javable.lessons.lesson8;

/**
 * Created by ruaval on 08.04.2015.
 */
public class A { //наследование
    int x;


    public static void main(String args[]) {
        A a = new A();
        B b = new B();
        a = b;
        a.x = new Integer(4);
        System.out.println();
        System.out.println(a.getClass());
        if (b instanceof A) {
            System.out.println("b instance of A");
        }
        if (a instanceof B) {
            System.out.println("a Instance of B");
        }
    }
}

class B extends A {

    int y;
}

