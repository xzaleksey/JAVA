package ru.geekbrains.practise.task23;

import java.util.Map;

public class Print implements Cmd {
    @Override
    public void exec(Map<String, Double> vars, String[] params, Stack<Double> stack) throws Exception {
        System.out.println(stack);
    }
}
