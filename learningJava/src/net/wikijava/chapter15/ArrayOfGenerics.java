package net.wikijava.chapter15;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la; //Предупреждение о
        // непроверенном преобразовании
        ls[0] = new ArrayList<>();
        // Приводит к ошибке на стадии компиляции :
        //! ls[1] = new ArrayList<Integer>();

        // Проблема: List<String> является подтипом Object
        Object[] objects = ls; // Поэтому присваивание возможно
        // Компилируется и выполняется без ошибок и предупреждений :
        objects[1] = new ArrayList<Integer>();

        // Но если ваши потребности достаточно элементарны.
        // создать массив параметризованных типов можно, хотя
        // и с предупреждением о "непроверенном" преобразовании
        List<BerylliumSphere>[] spheres =
                (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < spheres.length; i++)
            spheres[i] = new ArrayList<>();
    }
}