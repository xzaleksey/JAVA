package net.wikijava.chapter11;

import java.util.LinkedList;

import static net.valyakin.util.Print.print;

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets =
                new LinkedList<Pet>(Pets.arrayList(5));
        print(pets);
        // Идентично
        print("pets.getFirst(): " + pets.getFirst());
        print("pets.element(): " + pets.element());
        // Различие проявляется только для пустых списков:
        print("pets.peek(): " + pets.peek());
        // Идентично, удаление и возврат первого элемента.
        print("pets.remove(): " + pets.remove());
        print("pets.removeFirst(): " + pets.removeFirst());
        // Различие проявляется только для пустых списков:
        print("pets.poll(): " + pets.poll());
        print(pets);
        pets.addFirst(new Rat());
        print("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());
        print("After offer(): " + pets);
        pets.add(Pets.randomPet());
        print("After add(): " + pets);
        pets.addLast(new Hamster());
        print("After addLast(): " + pets);
        print("pets.removeLast(): " + pets.removeLast());
    }
}