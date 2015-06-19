package net.wikijava.chapter14.generic;

//---------------------------------------
//: generics/Holder.java
public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T val) {
        value = val;
    }

    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);
        // Holder<Fruit> Fruit = Apple; // Повышение невозможно
        Holder<? extends Fruit> fruit = Apple; // OK
        Fruit p = fruit.get();
        d = (Apple) fruit.get(); // Возвращает 'Object'
        try {
            Orange c = (Orange) fruit.get(); // Предупреждения нет
        } catch (Exception e) {
            System.out.println(e);
        }
        // fruit.set(new Apple()); // Вызов set() невозможен
        // fruit.set(new Fruit()); // Вызов set() невозможен
        System.out.println(fruit.equals(d)); // OK
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}
