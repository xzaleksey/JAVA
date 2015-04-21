/**
 * @author Алексей Валякин
 * @version 1.0
 */

public class Start {



    public static void main(String[] args) {
        try {
            return;
        } finally {
            System.out.println(System.getProperty("street"));
        }
//
//label1:
//        for (int i = 1072; i < 1092; i++) {
//            System.out.println((char) i + " " + i);
//            for (int j = 0; j <1 ; j++) {
//       continue label1;
//            }
//        }


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