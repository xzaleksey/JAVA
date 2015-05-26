package books.oreilly.chapter8;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class Mouse {

}

class Bear {

}

public class Trap<T> { //параметризованные классы и их использование
    T trapped;

    public static void main(String[] args) {

        // list trap
        Trap<Mouse> mouseTrap = new Trap<>();
        mouseTrap.snare(new Mouse());
        List<Mouse> list = new ArrayList<>();
        list.add(mouseTrap.release());
        mouseTrap.trapAll(list);

        //massiv
        Trap<Mouse>[] tma = new Trap[10];
        Trap<Mouse> tm = new Trap<>();
        tma[0] = tm;
        Trap<Mouse> again = tma[0];
        System.out.println(again);
        //obobchennie tipi

        ArrayList<?>[] arrayLists = new ArrayList<?>[10];
        arrayLists[0] = new ArrayList<Date>();
        Trap<?>[] traps = new Trap[10];
        traps[0] = new Trap<Mouse>();
    }

    public void snare(T trapped) {
        this.trapped = trapped;
    }

    public T release() {
        return trapped;
    }

    public void trapAll(List<T> list) {
        System.out.println("\n==> Iterator Example...");
        Iterator<T> tIterator = list.iterator();
        while (tIterator.hasNext()) {
            System.out.println(tIterator.next());
        }
    }
}
