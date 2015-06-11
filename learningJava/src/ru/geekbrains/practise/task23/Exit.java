package ru.geekbrains.practise.task23;

import java.util.Map;

public class Exit implements Cmd {
    @Override
    public void exec(Map<String, Double> vars, String[] params, Stack<Double> stack) {
        System.exit(0);
    }
}
