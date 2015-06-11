package ru.geekbrains.practise.task23;

import java.util.Map;

public class Push implements Cmd {
    @Override
    public void exec(Map<String, Double> vars, String[] params, Stack<Double> stack) throws Exception {
        try {
            stack.push(Double.parseDouble(params[1]));
        } catch (Exception e) {
            if (vars.containsKey(params[1])) {
                stack.push(Double.valueOf(vars.get(params[1])));
            } else throw new Exception();
        }
    }
}
