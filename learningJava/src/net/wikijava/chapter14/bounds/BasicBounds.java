package net.wikijava.chapter14.bounds;

interface HasColor {
    java.awt.Color getColor();
}

interface Weight {
    int weight();
}

class Colored<T extends HasColor> {
    T item;

    Colored(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    // Ограничение позволяет вызвать метод:
    java.awt.Color color() {
        return item.getColor();
    }
}

// Не работает -- сначала класс, потом интерфейсы:
// class ColoredDimension<T extends HasColor & Dimension> {

class Dimension {
    public int x, y, z;
}

// Несколько ограничений-
class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

// Как и при наследовании, конкретный класс может быть только один,
// а интерфейсов может быть несколько:
class Solid<T extends Dimension & HasColor & Weight> {
    T item;

    Solid(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

class Bounded
        extends Dimension implements HasColor, Weight {
    @Override
    public java.awt.Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid =
                new Solid<Bounded>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}