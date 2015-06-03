package net.wikijava.chapter13.toys;

import static net.mindview.util.Print.print;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    // Закомментируйте следующий далее конструктор по
    // умолчанию, тогда в строке с пометкой (*1*)
    // возникнет ошибка NoSuchMethodError
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        print("Имя класса: " + cc.getName() +
                " это интерфейс?[" + cc.isInterface() + "]");
        print("Простое имя: " + cc.getSimpleName());
        print("Каноническое имя: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("net.wikijava.chapter13.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            print("He найден класс FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Необходим конструктор по умолчанию:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("He удалось создать объект");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Нет доступа");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}