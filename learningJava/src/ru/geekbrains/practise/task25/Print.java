package ru.geekbrains.practise.task25;

import java.util.HashMap;
import java.util.Map;

public class Print extends Operator {
    public Print(String s) {
        super(s);
    }

    static String replaceWithVars(String s, HashMap<String, Double> vars) {
        for (Map.Entry<String, Double> entry : vars.entrySet()) {
            s = s.replaceAll(entry.getKey(), entry.getValue().toString());
        }
        return s;
    }

    @Override
    void execute(Interpreter interpreter) {
        String strings[] = code.split(";");
        for (String string : strings) {
            if (string.charAt(0) == '"' && string.charAt(string.length() - 1) == '"') {
                System.out.print(string.substring(1, string.length() - 1));
            } else {
                System.out.print(replaceWithVars(string, interpreter.getVars()));
            }
        }
        if (code.charAt(code.length() - 1) != ';') {
            System.out.println();
        }
        interpreter.nextLine();
    }
}
