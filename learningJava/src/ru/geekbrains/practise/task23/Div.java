package ru.geekbrains.practise.task23;

import java.util.Map;

public class Div implements Cmd {


    @Override
    public void exec(Map<String, Double> vars, String[] params, Stack<Double> stack) throws Exception {
        stack.push(stack.pop() / (stack.empty() ? 1 : stack.pop()));
    }
}
