package books.oreilly.chapter7.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

interface TypeWriter {
    void typeLine(String s);
}

class Printer implements TypeWriter {
    public String field = "value";

    @Override
    public void typeLine(String s) {
        System.out.println(s);
    }
}

public class MyApplication {
    static String outputDeviceName = Printer.class.getName();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        try {
            Class newClass = Class.forName(outputDeviceName);
            TypeWriter device = (TypeWriter) newClass.newInstance();
            device.typeLine("Hello");
            for (Method method : newClass.getMethods()) {
                System.out.println(method.getName());
                method.setAccessible(true);

//                Method method1= newClass.getDeclaredMethod(method.getName());
//                method1.setAccessible(true);
            }


            System.out.println(outputDeviceName);
            Field[] fields = newClass.getFields();
            Method method = Object.class.getDeclaredMethod("clone");
            int perms = method.getModifiers();
            System.out.println(Modifier.isPublic(perms));
            System.out.println(Modifier.isProtected(perms));
            System.out.println(Modifier.isPrivate(perms));
//            for (Method method: Calendar.class.getMethods()){
//                System.out.println(method.getModifiers());
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
