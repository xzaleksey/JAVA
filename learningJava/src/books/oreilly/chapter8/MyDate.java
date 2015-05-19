package books.oreilly.chapter8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Нижняя граница - MyDate
public class MyDate extends Date {
    public static void main(String[] args) {
        List<? super MyDate> list = new ArrayList<MyDate>();//нижняя граница
        list = new ArrayList<Date>();
        list = new ArrayList<Object>();
        List<? extends Date> list1 = new ArrayList<MyDate>();//верхняя граница
        //list1= new ArrayList<String>(); не расширяет Date, не скомпилируется
        //list = new ArrayList<String>(); Не скомпилируется, тк нижняя граница MyDate
    }
}
