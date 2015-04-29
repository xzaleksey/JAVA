package net.wikijava.chapter10.extending;


import static net.valyakin.util.Print.print;

class Egg {
    private Yolk y;

    public Egg() {
        print("New Egg()");
        y = new Yolk();
    }

    protected class Yolk {
        public Yolk() {
            print("Egg.Yolk()");
        }
    }
}

public class BigEgg extends Egg {
    public static void main(String[] args) {
        new BigEgg();
    }

    public class Yolk {
        public Yolk() {
            print("BigEgg.Yolk()");
        }
    }
}