package ru.geekbrains.practise.task23;

import java.util.Map;

public interface Cmd {
    void exec(Map<String, Double> vars, String[] params, Stack<Double> stack) throws Exception;
}
