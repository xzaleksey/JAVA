package books.oreilly.chapter6;


public class Animal {
    String food = "Eda";

    public Animal() {
        System.out.println("Animal Constructed");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        cat.eat();//вызовет метод из CAT
        System.out.println(((Animal) cat).food);// выдаст Eda из Animal
        Animal animal = cat;
        animal.eat(); //все равно молоко
        System.out.println(animal.food);//но выведет Eda
    }

    public void eat() {
        System.out.println(food);
    }
}

class Cat extends Animal {
    String food = "milk";

    public Cat() {
        super();
        System.out.println(food + "Cat const");
    }

    @Override

    public void eat() {
        System.out.println(food);
    }
}