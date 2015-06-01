package net.wikijava.chapter12;

import static net.valyakin.util.Print.print;

class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        print(this);
    }

    public void off() {
        state = false;
        print(this);
    }

    public String toString() {
        return state ? "on" : "off";
    }
}

//: exceptions/OnOffException1.java
class OnOffException1 extends Exception {
}

//: exceptions/OnOffException2.java
class OnOffException2 extends Exception {
}


//: exceptions/OnOffSwitch.java
// Зачем использовать finally?
class OnOffSwitch {
    private static Switch sw = new Switch();

    public static void f()
            throws OnOffException1, OnOffException2 {
        throw new OnOffException1();
    }

    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f();
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}

public class WithFinally {
    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            OnOffSwitch.f();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
}

