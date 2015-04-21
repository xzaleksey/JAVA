package net.wikijava.chapter9.stringprocessor;

import java.util.Arrays;

import static net.valyakin.util.Print.print;

interface Processor {
    String name();

    Object process(Object input);
}

//: interfaces/interfaceprocessor/Apply.java

class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
}

public abstract class StringProcessor implements Processor {
    public static String s =
            "If she weighs the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(), s);
        Apply.process(new Splitter(), s);
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public abstract String process(Object input);
}

class Upcase extends StringProcessor {
    @Override
    public String process(Object input) { // Covariant return
        return ((String) input).toUpperCase();
    }
}

class Downcase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}