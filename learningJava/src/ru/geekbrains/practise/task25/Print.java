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
        String s1 = "";
        String strings[] = code.split("\"");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].charAt(0) == '"' && strings[i].charAt(strings[i].length() - 1) == '"') {
                System.out.print(strings[i].substring(1, strings[i].length() - 1));
            } else {
                System.out.print(replaceWithVars(strings[i], interpreter.vars));
            }
        }
        interpreter.nextLine();
    }
}
