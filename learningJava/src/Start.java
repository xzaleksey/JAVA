/**
 * @author Алексей Валякин
 * @version 1.0
 */

public class Start {



    public static void main(String[] args) {

        for (int i = 1072; i < 1092; i++) {
            System.out.println((char) i + " " + i);
        }
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