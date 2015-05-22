/**
 * @author Алексей Валякин
 * @version 1.0
 */

enum Weekday {
    Sunday(8), Monday(0) {
        @Override
        public void die() {
            System.out.println("DIE!!!");
        }
    }, Tuesday(1), Wednesday(2), Thursday(4), Friday(6), Saturday(10);
    int fun;

    Weekday(int fun) {
        this.fun = fun;
    }

    public int getFun() {
        return fun;
    }

    public void die() {
        System.out.println("умри");
    }
}

interface A1 {

}

interface B1 extends A1 {

}

public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        int x = 5;
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(-0));
        int a = 5;
        a = ((~(a)) | 1 >> 31) + 1;
        System.out.println(a);
//
//  DateFormat dateFormat = new SimpleDateFormat("HHmm");
//        Date date = new Date();
//
//        System.out.println(dateFormat.format(date));
//        System.out.println("11:00 до 13:00".substring(0, 2));
//        Collection<String> stringCollection;
//        List<String> strings = new ArrayList<>();
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "s");
//        System.out.println(map.get(1));
//        stringCollection = strings;
//        List list = new ArrayList<Date>();
//        List<Date> dl = list;
//        dl.add(new Date(System.currentTimeMillis()));
//        System.out.println(list.get(0));
//        double d = Double.parseDouble("1");
//        Weekday[] weekdays = Weekday.values();
//        for (Weekday weekday : weekdays) {
//            System.out.println(weekday);
//            weekday.die();
//        }

//        try {
//            Integer i = 4;
//            Integer j =4;
//
//            if(i==j){
//                System.out.println("s");
//            }
//        } finally {
//            System.out.println(System.getProperty("street"));
//        }
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