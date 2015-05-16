package books.oreilly.chapter7.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class StringList extends ArrayList<String> {


    public static void main(String[] args) {
        Type type = StringList.class.getGenericSuperclass();//получает надКласс
        System.out.println(type);
        ParameterizedType pt = (ParameterizedType) type;//Параметризирует надкласс
        System.out.println(pt.getActualTypeArguments()[0]);//получает первый параметр
    }
}
