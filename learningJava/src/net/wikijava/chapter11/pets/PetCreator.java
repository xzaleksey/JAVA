package net.wikijava.chapter11.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
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
