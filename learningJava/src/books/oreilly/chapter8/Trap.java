package books.oreilly.chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Mouse {

}

class Bear {

}

public class Trap<T> { //параметризованные классы и их использование
    T trapped;

    public static void main(String[] args) {
        Trap<Mouse> mouseTrap = new Trap<>();
        mouseTrap.snare(new Mouse());
        List<Mouse> list = new ArrayList<>();
        list.add(mouseTrap.release());
        mouseTrap.trapAll(list);
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
