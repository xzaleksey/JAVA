package ru.geekbrains.practise.task25;

public class Goto extends Operator {
    public Goto(String s) {
        super(s);
    }

    @Override
    void execute(Interpreter interpreter) {
        interpreter.goToLine(Integer.parseInt(code));
    }

}
