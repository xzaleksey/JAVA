package net.wikijava.chapter7;

import static net.mindview.util.Print.print;

class Villain {
    private String name;

    public Villain(String name) {
        this.name = name;
    }

    protected void set(String nm) {
        name = nm;
    }

    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}

public class Orc extends Villain {
    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }

    public void change(String name, int orcNumber) {
        set(name); // Доступно, так как объявлено protected
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }
}