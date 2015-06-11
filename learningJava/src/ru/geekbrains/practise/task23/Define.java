package ru.geekbrains.practise.task23;

import java.util.Map;

public class Define implements Cmd {
    @Override
    public void exec(Map<String, Double> vars, String[] params, Stack<Double> stack) throws Exception {
        if (params.length == 3) {
            vars.put(params[1], Double.parseDouble(params[2]));
        } else throw new Exception();
    }
}
