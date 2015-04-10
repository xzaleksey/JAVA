package net.wikijava.Chapter5;

/**
 * Created by ruaval on 09.04.2015.
 */
//работа с this
class Person {
    public void eat(Apple apple) {
        System.out.println("хочу яблоко");
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        System.out.println("Очищаю яблоко");
        // ... remove peel
        return apple; // Peeled
    }
}

class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}

class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}