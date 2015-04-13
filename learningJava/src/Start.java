/**
 * @author Алексей Валякин
 * @version 1.0
 */

public class Start {
    public static void main(String[] args) {
        int size = Integer.MAX_VALUE;
        int p1 = 0;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {

            int p2 = i;
        }
        long t2 = System.currentTimeMillis();
        long d1 = t2 - t1;
        System.out.println("d1 = " + d1);

        t1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            p1 = i;
        }
        t2 = System.currentTimeMillis();
        long d2 = t2 - t1;
        System.out.println("d2 = " + d2);


    }

    public static void start(String className) {
        try {//обработка ошибок
            //TODO: Определение  класса
            Class c = Class.forName(className);//получить класс по его имени

            Object obj = c.newInstance(); //создать экземпляр

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        }
    }

}
