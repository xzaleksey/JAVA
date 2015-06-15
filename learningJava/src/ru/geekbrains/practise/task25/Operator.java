package ru.geekbrains.practise.task25;

public abstract class Operator {
    String code;

    public Operator(String s) {
        code = s;
    }

    abstract void execute(Interpreter interpreter);
}
