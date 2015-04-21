package net.wikijava.chapter9.interfaces;

//: interfaces/Adventure.java
// Использование нескольких интерфейсов.

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {
    }
}

class Hero extends ActionCharacter
        implements CanFight, CanSwim, CanFly {
    @Override
    public void swim() {
    }

    @Override
    public void fly() {
    }

    @Override
    public void fight() {
        System.out.println("X");
    }
}

public class Adventure {
    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h); // Используем объект в качестве типа CanFight
        u(h); // Используем объект в качестве типа CanSwim
        v(h); // Используем объект в качестве типа CanFly
        w(h); // Используем объект в качестве ActionCharacter

    }
}