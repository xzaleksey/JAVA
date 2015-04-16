import java.util.ArrayList;

/**
 * @author Алексей Валякин
 * @version 1.0
 */

public class Start {



    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("s");
        list.remove("n");
    }

    public static void start(String className) {
        Class c;
        try {//обработка ошибок
            //TODO: Определение  класса
            c = Class.forName(className);//получить класс по его имени
            try {
                Object obj = c.newInstance(); //создать экземпл
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}