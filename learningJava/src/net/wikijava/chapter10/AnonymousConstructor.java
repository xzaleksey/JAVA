package net.wikijava.chapter10;
//: innerclasses/AnonymousConstructor.java
// Создание конструктора для безымянного внутреннего класса.

import static net.mindview.util.Print.print;

abstract class Base {
    public Base(int i) {
        print("Base constructor, i = " + i);
    }

    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            {
                print("Inside instance initializer");
            }

            @Override
            public void f() {
                print("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        System.out.println(base.getClass().getName());
        if (base instanceof Base) {
            System.out.println(true);
            System.out.println(base.getClass().getSuperclass().getName());
        }
        base.f();
    }
}