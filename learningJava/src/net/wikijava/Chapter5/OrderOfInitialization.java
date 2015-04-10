package net.wikijava.Chapter5;

/**
 * Created by ruaval on 09.04.2015.
 */
// порядок инициализации
class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class House {
    Window w1 = new Window(1); // Перед конструктором
    Window w2 = new Window(2); // После конструктора
    Window w3 = new Window(3);  // В конце

    House() {
        // Показывает, что выполняется конструктор:
        System.out.println("House()");
        w3 = new Window(33); // Повторная инициализация w3
    }

    void f() {
        System.out.println("f()");
    }
}

class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f(); // Показывает, что объект сконструирован
    }
}
