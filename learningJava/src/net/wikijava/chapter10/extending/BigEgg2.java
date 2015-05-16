package net.wikijava.chapter10.extending;

import static net.valyakin.util.Print.print;

//: innerclasses/BigEgg2.java
// Правильное наследование внутреннего класса,
class Egg2 {
    private Yolk y = new Yolk();

    public Egg2() {
        print("New Egg2()");
    }

    public void insertYolk(Yolk yy) {
        y = yy;
    }

    public void g() {
        y.f();
    }

    protected class Yolk {
        public Yolk() {
            print("Egg2.Yolk()");
        }

        public void f() {
            print("Egg2.Yolk.f()");
        }
    }
}

public class BigEgg2 extends Egg2 {
    public BigEgg2() {
        insertYolk(new Yolk());
        System.out.println("BigEgg2 constructed");
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }

    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            print("BigEgg2.Yolk()");
        }

        @Override
        public void f() {
            print("BigEgg2.Yolk.f()");
        }
    }
}