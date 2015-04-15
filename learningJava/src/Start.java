import java.util.Random;

/**
 * @author Алексей Валякин
 * @version 1.0
 */

public class Start {


    public static int[] swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] dir = {0, 1, 2, 3};
        int counter = dir.length - 1;//длина массива
        while (counter > 0) { //перемешиваем массив
            int index = rnd.nextInt(counter + 1);
            dir = swap(dir, index, counter);
            --counter;
        }
        for (int d : dir) {
            System.out.println(d);
        }

       /* int size = Integer.MAX_VALUE;
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
*/

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