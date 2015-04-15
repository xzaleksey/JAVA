package net.wikijava.chapter7;

//: reusing/Bath.java
// Инициализация в конструкторе с композицией.


import java.util.logging.Logger;

import static net.valyakin.util.Print.print;

class Soap {
    private String s;

    Soap() {
        print("Soap()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}

public class Bath {

    private String // Инициализация в точке определения :
            s1 = "Happy",
            s2 = "Happy",
            s3, s4;
    private Soap castille;
    private int i;
    private float toy;

    // Инициализация экземпляра:
    {
        i = 47;
    }

    public Bath() {
        print("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        print(b);
        Logger l = Logger.getAnonymousLogger();

    }

    public String toString() {
        if (s4 == null) // Отложенная инициализация:
            s4 = "Joy";
        return
                "s1 = " + s1 + "\n" +
                        "s2 = " + s2 + "\n" +
                        "s3 = " + s3 + "\n" +
                        "s4 = " + s4 + "\n" +
                        "i = " + i + "\n" +
                        "toy = " + toy + "\n" +
                        "castille = " + castille;
    }
}