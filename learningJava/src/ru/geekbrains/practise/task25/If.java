package ru.geekbrains.practise.task25;

public class If extends Operator {
    public If(String s) {
        super(s);
    }

    @Override
    void execute(Interpreter interpreter) {
        Expression.parse(interpreter, code);
    }


}
