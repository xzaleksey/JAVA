package ru.geekbrains.practise.task22;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class StackCalc {
    public static void main(String[] args) {



        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Stack<Double> stack = new Stack();
            LinkedHashMap<String, Double> consts = new LinkedHashMap<>();
            outer:
            while (true) {
                String[] input = reader.readLine().split(" ");


                switch (input[0]) {
                    case "exit":
                        break outer;

                    case "add":
                        stack.push(stack.pop() + (stack.empty() ? 0 : stack.pop()));
                        break;
                    case "mul":
                        stack.push(stack.pop() * (stack.empty() ? 1 : stack.pop()));
                        break;
                    case "div":
                        stack.push(stack.pop() / (stack.empty() ? 1 : stack.pop()));
                        break;
                    case "pop":
                        System.out.println(stack.pop());
                        break;
                    case "print":
                        System.out.println(stack);
                        break;
                    case "push":
                        try {
                            stack.push(Double.parseDouble(input[1]));
                        } catch (Exception e) {
                            if (consts.containsKey(input[1])) {
                                stack.push(Double.valueOf(consts.get(input[1])));
                            } else throw new Exception();
                        }
                        break;
                    case "define":
                        if (input.length == 3) {
                            consts.put(input[1], Double.valueOf(input[2]));
                        } else throw new Exception();
                        break;


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Неправильный формат ввода данных");
        }

    }

    static class Stack<T> {
        private LinkedList<T> storage = new LinkedList<T>();

        public void push(T v) {
            storage.addFirst(v);
        }

        public T peek() {
            return storage.getFirst();
        }

        public T pop() {
            return storage.removeFirst();
        }

        public boolean empty() {
            return storage.isEmpty();
        }

        public String toString() {
            return storage.toString();
        }
    }
}
