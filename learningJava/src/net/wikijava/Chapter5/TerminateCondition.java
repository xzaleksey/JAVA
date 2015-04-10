package net.wikijava.Chapter5;

/**
 * Created by ruaval on 09.04.2015.
 */
class Book {
    boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    protected void finalize() {
        if (checkedOut)
            System.out.println("Error: checked out");
        // Обычно это делается так-:
        // super.finalize();  // Вызов версии базового класса
    }
}

class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        // Правильная очистка-:
        novel.checkIn();
        // Теряем ссылку, забыли про очистку:
        new Book(true);
        // запрос JVM на сборку мусора и финализация :
        System.gc();
    }
}