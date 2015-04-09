import net.wikijava.Chapter4.VowelsAndConsonants;

/**
 * @author Алексей Валякин
 * @version 1.0
 */

public class Start {
    public static void main(String[] args) {
//Vowels
        String s[] = new String[5];
        VowelsAndConsonants.main(s);

        //start("net.wikijava.Chapter4.LabeledFor");// Создание экземпляра класса по названию
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
