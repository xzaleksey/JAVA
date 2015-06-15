package ru.geekbrains.practise.task25;

public class Let extends Operator {
    public Let(String s) {
        super(s);
    }

    @Override
    void execute(Interpreter interpreter) {
        String[] parsed = code.split(" ");
        try {
            interpreter.getVars().put(parsed[0], Double.parseDouble(parsed[2]));
        } catch (Exception e) {
            interpreter.getVars().put(parsed[0], Expression.parse(interpreter, code));
        }
        interpreter.nextLine();
    }


}
