package com.javable.lessons.lesson9;

/**
 * Created by ruaval on 08.04.2015.
 */
public class Outer {

    int x = 0;

    public void g(final int j) {
        final int k = j;
        class Inner2 {

            public int f(int r) {
                System.out.println(r * k + j);
                return r * k + j;        // Здесь и j и k должны быть final
            }
        }
        Inner2 i1 = new Inner2();
        int s = i1.f(10);
    }

    class Inner1 {
        public int f() {
            return x++;
        }
    }
}

class Outside {
    public static void main(String[] args) {
        g1();
    }

    public static void g1() {
        Outer t1 = new Outer();
        Outer.Inner1 i2 = t1.new Inner1();
        i2.f();
        t1.g(5);

    }
}
