package ru.geekbrains.forksenia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeMap;


public class StackCalc {
    public static void main(String[] args) throws IOException {
        String str = " ";
        Stack<Double> stack = new Stack<Double>();
        TreeMap<String, Double> tm = new TreeMap<String, Double>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                str = reader.readLine();
                str = str.toLowerCase();
                String s[] = str.split(" ");
                if ("push".equals(s[0])) {
                    if (tm.containsKey(s[1])) {
                        stack.push(tm.get(s[1]));
                    } else {
                        double k = 0;
                        try {
                            k = Double.parseDouble(s[1]);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        stack.push(k);
                        System.out.println(stack);
                    }

                } else if ("add".equals(s[0])) {
                    if (stack.empty()) {
                        System.out.println("Стэк пустой");
                    }
                    System.out.println("Yeap");
                    stack.push(stack.pop() + (stack.empty() ? 0 : stack.pop()));
                    System.out.println(stack);
                } else if ("mul".equals(s[0])) {
                    if (stack.empty()) {
                        System.out.println("Стэк пустой");
                    }
                    stack.push(stack.pop() * (stack.empty() ? 1 : stack.pop()));
                    System.out.println(stack);
                } else if ("div".equals(s[0])) {
                    if (stack.empty()) {
                        System.out.println("Стэк пустой");
                    }
                    stack.push(stack.pop() / (stack.empty() ? 1 : stack.pop()));
                    System.out.println(stack);
                } else if ("define".equals(s[0])) {

                    try {
                        tm.put(s[1], Double.parseDouble(s[2]));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tm);

                } else if ("print".equals(s[0])) {
                    System.out.println(stack);
                } else if ("exit".equals(s[0])) {
                    break;
                }

            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }

    }
}
