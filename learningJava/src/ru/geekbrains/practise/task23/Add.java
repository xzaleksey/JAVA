package ru.geekbrains.practise.task23;

import java.util.Map;

public class Add implements Cmd {
    @Override
    public void exec(Map<String, Double> vars, String[] params, Stack<Double> stack) throws Exception {
        stack.push(stack.pop() + (stack.empty() ? 0 : stack.pop()));
    }
}
