package net.wikijava.chapter10;

//: innerclasses/Parcel7.java
// Метод возвращает экземпляр безымянного внутреннего класса
public class Parcel7 {
    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        System.out.println(c.value());
    }

    public Contents contents() {
        return new Contents() {// Вставить определение класса
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };  // В данной ситуации точка с запятой необходима
    }
}