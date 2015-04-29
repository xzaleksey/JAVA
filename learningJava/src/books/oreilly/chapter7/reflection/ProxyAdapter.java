
package books.oreilly.chapter7.reflection;

import java.lang.reflect.InvocationHandler;

public class ProxyAdapter {
    InvocationHandler handler = (proxy, method, args) -> {
        System.out.println("Method: {[QUOTE-REPLACEMANT]}" + method.getName() + "()" + " of interface: " + " invoked on proxy!");
        return null;
    };

    public static void main(String[] args) {

    }
}
