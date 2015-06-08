package net.wikijava.chapter14;

import java.util.*;

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
    }

    // A method to produce Generator objects:
    public static Generator<Customer> generator() {
        return () -> new Customer();
    }

    public String toString() {
        return "Customer " + id;
    }
}

class Teller {
    // Метод для получения объектов Generator:
    public static Generator<Teller> generator =
            () -> new Teller();
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    public String toString() {
        return "Teller " + id;
    }
}

public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " обслуживает " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line)
            serve(tellers.get(rand.nextInt(tellers.size())), c);
    }
}
