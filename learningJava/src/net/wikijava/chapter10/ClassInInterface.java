package net.wikijava.chapter10;

public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {
        public static void main(String[] args) {
            new Test().howdy();
        }

        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }
    }
}