package net.wikijava.chapter6;

import static net.mindview.util.Print.print;

/**
 * Created by ruaval on 13.04.2015.
 */
class Sundae {
    private Sundae() {
    } // Нельзя создать экземпляр из другого класса

    static Sundae makeASundae() { // возвращает экземпляр класса
        return new Sundae();
    }
}

public class IceCream {
    public static void main(String[] args) {
        //! Sundae x = new Sundae();
        Sundae x = Sundae.makeASundae();
        print(x);
        System.out.println(Math.PI);
    }
}
