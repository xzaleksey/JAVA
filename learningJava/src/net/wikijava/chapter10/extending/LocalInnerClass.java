package net.wikijava.chapter10.extending;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner ");
        for (int i = 0; i < 5; i++)
            print(c1.next());
        for (int i = 0; i < 5; i++)
            print(c2.next());
    }

    Counter getCounter(final String name) {
        // Локальный внутренний класс:
        class LocalCounter implements Counter {
            public LocalCounter() {
                // У локального внутреннего класса
                // может быть собственный конструктор:
                print("LocalCounter()");
            }

            @Override
            public int next() {
                printnb(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }

    // To же самое с безымянным внутренним классом:
    Counter getCounter2(final String name) {
        return new Counter() {
            // У безымянного внутреннего класса не может быть
            // именованного конструктора, «легальна» только
            // инициализация экземпляром:
            {
                print("Counter()");
            }

            @Override
            public int next() {
                printnb(name); // final аргумент
                return count++;
            }
        };
    }
}