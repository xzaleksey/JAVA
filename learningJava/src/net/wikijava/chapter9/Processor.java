package net.wikijava.chapter9;

import java.util.Arrays;

import static net.mindview.util.Print.print;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override
    String process(Object input) { // Ковариантный возвращаемый тип
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override
    String process(Object input) {
        // Аргумент split() используется для разбиения строки
        return Arrays.toString(((String) input).split(" "));
    }
}

class Apply {
    public static String s =
            "Disagreement with beliefs is by definition incorrect";

    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}
