package books.oreilly.chapter7.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class Invoke {
    public static String out() {
        return ("Хэй");
    }

    public static void main(String[] args) {
        Class clas = null;
        try {
            clas = Class.forName(args[0]);
            Method method = clas.getMethod(args[1]);
            System.out.println(method.getReturnType());
            Object ret = method.invoke(null);
            System.out.println("Invoked static method " + args[1] + " Of class " + args[0] + "With no args\nResults: " + ret);
            Constructor<Date> cons = Date.class.getConstructor(String.class);
            Date date = cons.newInstance("Apr 24, 2015");
            String[] array = (String[]) Array.newInstance(String.class, 5);
            System.out.println(Arrays.toString(array));
            System.out.println(date);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
