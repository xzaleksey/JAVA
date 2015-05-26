package ru.geekbrains.practise.task04;

public class LongNumbers {
    // todo * исправить ошибку
    // todo * пусть на консоль выводится только сумма
    public static void main(String[] args) {
        String a = "99999999999", b = "99999999999999";
        // System.out.println(a.length() + "\n" + b.length());
        sum2(a, b);//не оптимальный
        sum(a, b);//получше
    }

    static void sum(String a, String b) {
        String result = "";
        if ((a.length() < b.length())) {// делаем максимальное число a
            result = b;
            b = a;
            a = result;
            result = "";
        }
        int temp;
        int dif = a.length() - b.length();//разница в количестве символов
        byte b1 = 0;//для добавления
        for (int i = a.length() - 1; i >= 0; i--) {
            if (dif - i <= 0) {//складываем 2 числа
                temp = Integer.parseInt(a.substring(i, i + 1)) + Integer.parseInt(b.substring(-dif + i, -dif + i + 1)) + b1;// с конца считаем
            } else { //если минимальное число все прошло
                    temp = Integer.parseInt(a.substring(i, i + 1)) + b1;
            }

            if (temp > 9 && i > 0) {
                temp -= 10;
                b1 = 1;
            } else b1 = 0;
            result = temp + result;
        }

        System.out.println(result);
    }

    static void sum2(String a, String b) {
        String result = "";
        if ((a.length() < b.length())) {// делаем максимальное число a
            result = b;
            b = a;
            a = result;
            result = "";
        }
        if (Math.ceil(a.length() / 18.) > 1) {//символов много и нужно бить на части
            long temp;
            byte b1 = 0;
            while (!(b.length() == 0)) {//проход по минимальному
                temp = getLong(b) + getLong(a) + b1;
                if (temp > 999999999999999999l) {//перенос 1
                    b1 = 1;
                    temp = Long.parseLong(String.valueOf(temp).substring(1));
                } else if (b1 == 1) {
                    b1 = 0;
                }
                result = temp + result;
                a = cut(a);
                b = cut(b);
            }
            while (!(a.length() == 0)) {//добираем большее число
                result = (getLong(a) + b1) + result;
                a = cut(a);
                if (b1 == 1) {
                    b1 = 0;
                }
            }
        } else {
            long l = Long.parseLong(a) + Long.parseLong(b);
            System.out.println(Long.valueOf(l).toString());
        }
        System.out.println(result);
    }

    static long getLong(String s) {
        long res;
        try {
            res = Long.parseLong(s.substring(s.length() - 18, s.length()));
        } catch (Exception ex) {
            res = Long.parseLong(s);
        }
        return res;
    }

    static String cut(String s) {
        try {
            s = s.substring(0, s.length() - 18);
            return s;
        } catch (Exception ex) {
            return "";
        }
    }
}
