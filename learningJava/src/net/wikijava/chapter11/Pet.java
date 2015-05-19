package net.wikijava.chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Pet extends Individual {
    public Pet(String name) {
        super(name);
    }

    public Pet() {
        super();
    }
}

class Person extends Individual {
    public Person(String name) {
        super(name);
    }
}

//typeinfo/pets/Dog.java
class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }
}

//typeinfo/pets/Cat.java
class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }
}

//typeinfo/pets/Rodent.java
class Rodent extends Pet {
    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
        super();
    }
}

//typeinfo/pets/Pug.java
class Pug extends Dog {
    public Pug(String name) {
        super(name);
    }

    public Pug() {
        super();
    }
}

//typeinfo/pets/Mutt.java
class Mutt extends Dog {
    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
        super();
    }
}

//typeinfo/pets/EgyptianMau.java
class EgyptianMau extends Cat {
    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
        super();
    }
}

//typeinfo/pets/Manx.java
class Manx extends Cat {
    public Manx(String name) {
        super(name);
    }

    public Manx() {
        super();
    }
}

//typeinfo/pets/Cymric.java
class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
        super();
    }
}

//typeinfo/pets/Rat.java
class Rat extends Rodent {
    public Rat(String name) {
        super(name);
    }

    public Rat() {
        super();
    }
}

//typeinfo/pets/Mouse.java
class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }
}

//typeinfo/pets/Hamster.java
class Hamster extends Rodent {
    public Hamster(String name) {
        super(name);
    }

    public Hamster() {
        super();
    }
}

abstract class PetCreator {
    //инициализация генератора случайных чисел
    private Random rand = new Random(47);

    //абстрактный метод возвращает список возможных типов(классов) животных
    public abstract List<Class<? extends Pet>> getTypes();


    public Pet randomPet() { // Создание одного случайного объекта Pet
        // генерация случайного номера в диапазоне списка классов животных
        int n = rand.nextInt(getTypes().size());
        try {//создание нового объекта для класса с данным номером в списке классов
            return getTypes().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public Pet[] createArray(int size) {//создание массива случайных Pet
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++)
            result[i] = randomPet();
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {// создание списка случайных Pet
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
