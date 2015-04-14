package net.wikijava.chapter7;

//: reusing/Wind.java
// Наследование и восходящее преобразование.

class Instrument {
    static void tune(Instrument i) {
        // ...
        i.play();
    }

    public void play() {
        System.out.println(this + " Играть");
    }
}

// Объекты Wind также являются объектами Instrument,
// поскольку они имеют тот же интерфейс:
public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); // Восходящее преобразование
    }

    @Override
    public String toString() {
        return "Wind{}";
    }
}