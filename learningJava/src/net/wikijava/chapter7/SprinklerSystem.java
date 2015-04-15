package net.wikijava.chapter7;

import static net.valyakin.util.Print.print;

class WaterSource {
    private String s;

    WaterSource() {
        print("WaterSource()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}

public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        print(sprinklers);
    }

    public String toString() {
        return
                "valve1 = " + valve1 + " " +
                        "valve2 = " + valve2 + " " +
                        "valve3 = " + valve3 + " " +
                        "valve4 = " + valve4 + "\n" +
                        "i = " + i + " " + "f = " + f + " " +
                        "source = " + source;
    }
}