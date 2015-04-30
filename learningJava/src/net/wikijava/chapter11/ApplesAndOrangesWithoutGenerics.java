package net.wikijava.chapter11;

import java.util.ArrayList;

class Apple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {
}

public class ApplesAndOrangesWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        // He препятствует добавлению объекта Orange:
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++)
            ((Apple) apples.get(i)).id();
        // Объект Orange обнаруживается только во время выполнения
    }
}