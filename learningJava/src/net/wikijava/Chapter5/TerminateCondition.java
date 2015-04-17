package net.wikijava.Chapter5;

/**
 * Created by ruaval on 09.04.2015.
 */
class Book {
    String name;
    boolean checkedOut = false;

    Book(boolean checkOut, String name) {
        checkedOut = checkOut;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", checkedOut=" + checkedOut +
                '}';
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize() {
        if (checkedOut)
            System.out.println("Error: checked out");
        System.out.println(this);
        // Обычно это делается так-:
        // super.finalize();  // Вызов версии базового класса
    }
}

class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true, "1");
        // Правильная очистка-:
        novel.checkIn();
        // Теряем ссылку, забыли про очистку:
        new Book(true, "2");
        // запрос JVM на сборку мусора и финализация :
        System.gc();
    }
}