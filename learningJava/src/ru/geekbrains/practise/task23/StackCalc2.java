package ru.geekbrains.practise.task23;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StackCalc2 {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            LinkedHashMap<String, Cmd> cmds = new LinkedHashMap<String, Cmd>() {
                {
                    put("exit", new Exit());
                    put("print", new Print());
                    put("define", new Define());
                    put("push", new Push());
                    put("add", new Add());
                    put("mul", new Mul());
                    put("div", new Div());
                    put("pop", new Pop());
                }
            };
            Stack stack = new Stack();
            Map<String, Double> vars = new HashMap<>();

            while (true) {

                String[] params = reader.readLine().split(" ");
                try {


                    if (cmds.containsKey(params[0])) {
                        cmds.get(params[0]).exec(vars, params, stack);
                    } else System.out.println("Такой команды нет");
                } catch (Exception e) {
                    System.out.println("Неправильный формат ввода данных");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
