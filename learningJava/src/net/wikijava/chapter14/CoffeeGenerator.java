package net.wikijava.chapter14;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator
        implements Generator<Coffee>, Iterable<Coffee> {
    private static Random rand = new Random(47);
    private Class[] types = {Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class,};
    //Для перебора
    private int size = 0;

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
        for (Coffee c : new CoffeeGenerator(5))
            System.out.println(c);
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee)
                    types[rand.nextInt(types.length)].newInstance();
            // Сообщение об ошибках во время выполнения:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {// He реализован
            throw new UnsupportedOperationException();
        }
    }
}