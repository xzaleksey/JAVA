/**
 * Created by ruaval on 07.04.2015.
 */

public class Start {
    public static void main(String[] args) {

        start("com.javable.lessons.lesson7.Dialog3");// Создание экземпляра класса по названию
    }

    public static void start(String className) {
        try {//обработка ошибок
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
