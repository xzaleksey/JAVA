package net.wikijava.chapter13;

import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Ошибка компиляции, символическое имя 'С' не найдено
    /* if(a instanceof C) {
      C c = (C)a;
      c.g();
    } */
        // Однако рефлексия позволяет вызвать g():
        callHiddenMethod(a, "g");
        // ... И даже еще менее доступные методы!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName)
            throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}