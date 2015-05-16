package books.oreilly.chapter7.reflection;

import java.util.HashMap;

public class DeepSheep implements Cloneable {
    HashMap flock = new HashMap();
    int legs = 3;

    public static void main(String[] args) {
        DeepSheep sheep1 = new DeepSheep();
        sheep1.flock.put("1", "на");
        DeepSheep sheep2 = sheep1.clone();
        System.out.println(sheep2.legs);
        System.out.println(sheep1.flock + " " + sheep2.flock);
        sheep1.flock.put("2", "на");
        System.out.println(sheep1.flock + " " + sheep2.flock);
        System.out.println(sheep1.getClass());
    }

    @Override
    public DeepSheep clone() {
        try {
            DeepSheep copy = (DeepSheep) super.clone();
            copy.flock = (HashMap) flock.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        throw new Error("Это не должно происходить никогда! Бугага");
    }
}
