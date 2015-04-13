package net.valyakin.util;

/**
 * Created by ruaval on 13.04.2015.
 */

import java.io.PrintStream;

public class Print { //Принт для избежания повторяющегося кода
    // Печать с переводом строки:
    public static void print(Object obj) {
        System.out.println(obj);
    }

    // Перевод строки:
    public static void print() {
        System.out.println();
    }

    // Печать без перевода строки:
    public static void printnb(Object obj) {
        System.out.print(obj);
    }

    // Новая конструкция Java SE5 printf() (from C):
    public static PrintStream
    printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}