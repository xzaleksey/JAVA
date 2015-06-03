package net.wikijava.chapter11;

import net.wikijava.chapter11.pets.*;

import java.util.*;

import static net.mindview.util.Print.print;

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.arrayList(7);
        print("1: " + pets);
        Hamster h = new Hamster();
        pets.add(h); // Автоматическое изменение размера
        print("2: " + pets);
        print("3: " + pets.contains(h));
        pets.remove(h); // Удаление объекта
        Pet p = pets.get(2);
        print("4: " + p + " " + pets.indexOf(p));
        Pet cymric = new Cymric();
        print("5: " + pets.indexOf(cymric));
        print("6: " + pets.remove(cymric));
        // Точно заданный объект:
        print("7: " + pets.remove(p));
        print("8: " + pets);
        pets.add(3, new Mouse()); // Вставка no индексу
        print("9: " + pets);
        List<Pet> sub = pets.subList(1, 4);
        print("subList: " + sub);
        print("10: " + pets.containsAll(sub));
        Collections.sort(sub); // Сортировка "на месте"
        print("sorted subList: " + sub);
        // Для containsAll() порядок неважен:
        print("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, rand); // Случайная перестановка
        print("shuffled subList: " + sub);
        print("12: " + pets.containsAll(sub));
        List<Pet> copy = new ArrayList<Pet>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);
        print("13: " + copy);
        copy = new ArrayList<Pet>(pets); // Получение новой копии
        copy.remove(2); // Удаление по индексу
        print("14: " + copy);
        copy.removeAll(sub); // Удаление заданных элементов print("15: " + copy);
        print("15: " + copy);
        copy.set(1, new Mouse()); // Замена элемента
        print("16: " + copy);
        copy.addAll(2, sub); // Вставка в середину списка
        print("17: " + copy);
        print("18: " + pets.isEmpty());
        pets.clear(); // Удаление всех элементов
        print("19: " + pets);
        print("20: " + pets.isEmpty());
        pets.addAll(Pets.arrayList(4));
        print("21: " + pets);
        Object[] o = pets.toArray();
        print("22: " + o[3]);
        Pet[] pa = pets.toArray(new Pet[0]);
        print("23: " + pa[3].id());
    }
}