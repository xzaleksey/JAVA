package books.oreilly.chapter7;

import java.util.HashMap;

public class Sheep implements Cloneable {
    HashMap flock = new HashMap();
    int legs = 3;

    public static void main(String[] args) {
        Sheep sheep1 = new Sheep();
        Sheep sheep2 = sheep1.clone();
        System.out.println(sheep2.legs);
        System.out.println(sheep1.flock + " " + sheep2.flock);
    }

    @Override
    public Sheep clone() {
        try {
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        throw new Error("Это не должно происходить никогда! Бугага");
    }
}
