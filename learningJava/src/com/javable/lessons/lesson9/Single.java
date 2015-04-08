package com.javable.lessons.lesson9;

/**
 * Created by ruaval on 08.04.2015.
 */
public class Single {

    private static Single instance = null;

    protected Single() {
        System.out.println("Я создался один!");
    }

    public static final Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }

}