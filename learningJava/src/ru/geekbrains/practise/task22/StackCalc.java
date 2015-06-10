package ru.geekbrains.practise.task22;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class StackCalc {
    public static void main(String[] args) {

        Stack<Double> stack = new Stack();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String[] input = reader.readLine().split(" ");
                if ("exit".equals(input[0])) break;
                else if ("push".equals(input[0])) stack.push(Double.parseDouble(input[1]));
                else if ("add".equals(input[0])) {
                    stack.push(stack.pop() + (stack.empty() ? 0 : stack.pop()));
                } else if ("mul".equals(input[0])) stack.push(stack.pop() * (stack.empty() ? 1 : stack.pop()));
                else if ("div".equals(input[0])) stack.push(stack.pop() / (stack.empty() ? 1 : stack.pop()));
                else if ("print".equals(input[0])) System.out.println(stack);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
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
