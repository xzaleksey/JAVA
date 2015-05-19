package ru.geekbrains.practise.task03;

public class Bikvadrat {
    public static void main(String[] args) {
        int a = 4, b = -4, c = 0;
        solution(a, b, c);
    }

    static void solution(int a, int b, int c) {
        String result = "";
        if (a == 0) {//квадратное уравнение
            if (b == 0) {
                result = "Уравнения нет.";
            } else if ((b > 0 && c > 0) || (b < 0 && c < 0)) {//-5x^2=6 корней нет
                result = "Уравнение квадратное. Корней нет";
            } else {
                System.out.println("Корень 1: " + (Math.sqrt(-c / b)) + "\n" + "Корень 2: " + (-Math.sqrt(-c / b)));
            }
        } else if (b == 0) {// ax^4 +c
            if ((a > 0 && c > 0) || (a < 0 && c < 0)) {
                result = "Уравнение биквадратное. Корней нет";
            } else {
                result = "Корень 1:" + (Math.pow((-c / a), 0.25) + "\n" + "Корень 2:" + (-(Math.pow((-c / a), 0.25))));
            }
        } else {//a <>0 b<>0 ax^4 + bx^2 +c
            double d = diskr(a, b, c);
            if (!checkPositive(d)) {
                result = "Биквадратное уравнение. Корней нет";
            } else { // если корень
                double d1 = (-b + Math.sqrt(d)) / (2 * a);
                byte counter = 1;
                d1 = (-b - Math.sqrt(d)) / (2 * a);
                result += checkRoots(d, d1, counter);
                counter += 2;
                d1 = (-b + Math.sqrt(d)) / (2 * a);
                result += checkRoots(d, d1, counter);
            }
        }
        System.out.println(result);
    }

    static String checkRoots(double d, double d1, byte counter) {
        String result = "";
        if (!checkPositive(d1)) {
            result += "Корень" + counter + ": не вещественный \n";
            result += "Корень" + (counter + 1) + ": не вещественный\n";
        } else {
            result += "Корень" + counter + ": " + Math.sqrt(d1) + "\n";
            result += "Корень" + (counter + 1) + ": " + -Math.sqrt(d1) + "\n";
        }
        return result;
    }

    static double diskr(int a, int b, int c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    static boolean checkPositive(double d) {
        return d >= 0;
    }
}
