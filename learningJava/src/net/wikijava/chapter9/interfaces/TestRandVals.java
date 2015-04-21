package net.wikijava.chapter9.interfaces;

import java.util.Random;

import static net.valyakin.util.Print.print;

interface RandVals {
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt(10);
    long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextLong() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;

    class TestRandVals {
        public static void main(String[] args) {
            print(RandVals.RANDOM_INT);
            print(RandVals.RANDOM_LONG);
            print(RandVals.RANDOM_FLOAT);
            print(RandVals.RANDOM_DOUBLE);
        }
    }
}