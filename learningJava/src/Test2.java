import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class X {
    public int i = 5;
    int[][] ar;

    public int addI(int x) {
        List<Double> s = new ArrayList();
        return i + x;
    }
}

public class Test2 extends ArrayList<String> {

    static int l = 6;

    static {
        l = 5;
        System.out.println("first");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
//        Type type = Test2.class.getGenericSuperclass();
//        System.out.println(type);
//        ParameterizedType parameterizedType = (ParameterizedType) type;
//        System.out.println(parameterizedType.getActualTypeArguments()[0]);
       /* InvocationHandler handler = (proxy, method, args1) -> {
            System.out.println("Method: {[QUOTE-REPLACEMENT]}" + method.getName() + "()" + " of interface: " + "invoked on proxy!");
            return 10;
        };

        Class aClass = Class.forName("MyInterface");
        MyInterface myInterfaceProxy = (MyInterface)Proxy.newProxyInstance(aClass.getClassLoader(),new Class[]{aClass},handler );
        System.out.println(myInterfaceProxy.getInt());*/
        long startTime;
        X x = new X();
        startTime = System.currentTimeMillis();
        Method method = X.class.getDeclaredMethod("addI", int.class);
        method.setAccessible(true);
        System.out.println((System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            method.invoke(x, i);
//            x.i+=i;
        }

        System.out.println((System.currentTimeMillis() - startTime));
        System.out.println(l);
    }
}