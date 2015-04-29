package net.wikijava.chapter10;

//: innerclasses/Parcel5.java
// Вложение класса в тело метода.
public class Parcel5 {
    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());
    }

    public Destination destination(String s) {
        class PDestination implements Destination {
            public int c = 10;
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }
}