package net.wikijava.chapter9.music5;

import net.wikijava.chapter8.music.Note;

import static net.valyakin.util.Print.print;

interface Instrument {
    // Константа времени компиляции:
    int VALUE = 5; // static & final

    // Определения методов недопустимы:
    void play(Note n); // Автоматически объявлен как public
}

class Wind implements Instrument {
    @Override
    public void play(Note n) {
        print(this + ".play() " + n);
    }

    public String toString() {
        return "Wind";
    }

    public void adjust() {
        print(this + ".adjust()");
    }
}

class Percussion implements Instrument {
    @Override
    public void play(Note n) {
        print(this + ".play() " + n);
    }

    public String toString() {
        return "Percussion";
    }

    public void adjust() {
        print(this + ".adjust()");
    }
}

class Stringed implements Instrument {
    @Override
    public void play(Note n) {
        print(this + ".play() " + n);
    }

    public String toString() {
        return "Stringed";
    }

    public void adjust() {
        print(this + ".adjust()");
    }
}

class Brass extends Wind {
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    public String toString() {
        return "Woodwind";
    }
}

public class Music5 {
    // Работа метода не зависит от фактического типа объекта.
    // поэтому типы, добавленные в систему, будут работать правильно:
    static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e)
            tune(i);
    }

    public static void main(String[] args) {
        // Восходящее преобразование при добавлении в массив:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}