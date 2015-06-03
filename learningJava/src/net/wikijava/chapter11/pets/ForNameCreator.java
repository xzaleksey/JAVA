package net.wikijava.chapter11.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {
            "net.wikijava.chapter11.pets.Mutt",
            "net.wikijava.chapter11.pets.Pug",
            "net.wikijava.chapter11.pets.EgyptianMau",
            "net.wikijava.chapter11.pets.Manx",
            "net.wikijava.chapter11.pets.Cymric",
            "net.wikijava.chapter11.pets.Rat",
            "net.wikijava.chapter11.pets.Mouse",
            "net.wikijava.chapter11.pets.Hamster"
    };

    // статический блок ОДНОКРТАНО загружающий список при инициализации данного класса
    static {
        loader();
    }

    @SuppressWarnings("unchecked")
// загрузчик списка классов
    private static void loader() {
        try { //при загрузке класс приводится к типу заданному типизациии контейнера
            for (String name : typeNames)
                types.add((Class<? extends Pet>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Class<? extends Pet>> getTypes() {
        return types;
    }
}