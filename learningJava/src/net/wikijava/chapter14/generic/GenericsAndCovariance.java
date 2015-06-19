package net.wikijava.chapter14.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
        // Метасимволы обеспечивают ковариантность:
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Ошибка компиляции: добавление объекта
        // произвольного типа невозможно
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // Можно, но неинтересно
        // Мы знаем, что возвращается по крайней мере Fruit:
        Fruit f = flist.get(0);
    }
}