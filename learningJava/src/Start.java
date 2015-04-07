/**
 * Created by ruaval on 07.04.2015.
 */

public class Start {
    public static void main(String[] args) {

        start("com.javable.lessons.lesson7.Dialog3");
    }

    public static void start(String className) {
        try {
            Class c = Class.forName(className);
            Object obj = c.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        }
    }

}
