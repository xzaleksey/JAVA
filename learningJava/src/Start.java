/**
 * Created by ruaval on 07.04.2015.
 */

import com.javable.lessons.lesson7.Derived;

public class Start {
    public static void main(String[] args) {
        Derived d = new Derived("test", 10);
        long c = d.g(5);
        long p = d.f();
    }
}
