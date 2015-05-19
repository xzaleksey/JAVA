package books.oreilly.chapter8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestLists {
    public static void main(String[] args) {
        List<?> list = new ArrayList<Date>();
        list = new ArrayList<String>();
        System.out.println(list.getClass());

    }
}

