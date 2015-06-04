package net.wikijava.chapter14;

import net.wikijava.chapter11.pets.Pet;
import net.wikijava.chapter13.Person;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
        System.out.println(petPeople);
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
}