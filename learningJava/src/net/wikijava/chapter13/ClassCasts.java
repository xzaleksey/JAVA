package net.wikijava.chapter13;

class Building {
}

class House extends Building {
}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        System.out.println(h.getClass().getCanonicalName());
        h = (House) b; // ... or just do this.
        Object o = new House();
    }
}
