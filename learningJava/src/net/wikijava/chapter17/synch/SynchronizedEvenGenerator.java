package net.wikijava.chapter17.synch;

//: concurrency/SynchronizedEvenGenerator.java
// Упрощение работы с мьютексами с использованием
// ключевого слова synchronized.
// {RunByHand}

import net.wikijava.chapter17.concurrency.EvenChecker;
import net.wikijava.chapter17.concurrency.IntGenerator;

public class
        SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Ускоряем сбой
        ++currentEvenValue;
        return currentEvenValue;
    }
}
