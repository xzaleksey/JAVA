package net.wikijava.chapter13;

import static net.mindview.util.Print.print;

class Candy {
    static {
        print("Загрузка класса Candy");
    }
}

class Gum {
    static {
        print("Загрузка класса Gum");
    }
}

class Cookie {
    static {
        print("Загрузка класса Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        print("в методе main()");
        new Candy();
        print("После создания объекта Candy");
        try {
            System.out.println(Gum.class.getName());
            Class.forName("net.wikijava.chapter13.Gum");
        } catch (ClassNotFoundException e) {
            print("Класс Gum не найден");
        }
        print("После вызова метода Class.forName(\"Gum\")");
        new Cookie();
        print("После создания объекта Cookie");
    }
}