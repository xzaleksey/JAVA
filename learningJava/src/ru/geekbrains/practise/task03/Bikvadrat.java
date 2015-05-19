package ru.geekbrains.practise.task03;

public class Bikvadrat {
    public static void main(String[] args) {
        int a = 2, b = 2, c = 0;
        solution(a, b, c);
    }

    static void solution(int a, int b, int c) {
        String result = "Уравнение биквадратное.";
        double roots[] = new double[0];
        if (a == 0) {//квадратное уравнение
            if (b == 0) {
                result = "Уравнения нет.";
            } else if ((b > 0 && c > 0) || (b < 0 && c < 0)) {//-5x^2=6 корней нет
                result = "Уравнение квадратное.";
            } else {
                roots = initRoots(2);
                roots = setRoots(roots, 0, -c / b);
            }
        } else if (b == 0) {// ax^4 +c
            if (!(a > 0 && c > 0) || (a < 0 && c < 0)) {
                roots = initRoots(2);
                roots[0] = (Math.pow((-c / a), 0.25));
                roots[1] = -roots[0];
            }
        } else {//a <>0 b<>0 ax^4 + bx^2 +c

            double d = diskr(a, b, c);
            if (checkPositive(d)) {
                double d1, d2;
                byte counter;
                boolean first = true;
                d1 = (-b - Math.sqrt(d)) / (2 * a);
                d2 = (-b + Math.sqrt(d)) / (2 * a);
                counter = getRootsCount(d1);
                if (counter == 0) {
                    first = false;
                }
                counter += getRootsCount(d2);
                roots = initRoots(counter);
                if (counter == 4) {
                    for (int i = 0; i < roots.length; i = i + 2) {
                        roots[i] = Math.sqrt(d1);
                        roots[i + 1] = -roots[i];
                        d1 = d2;
                    }

                } else if (first) {
                    roots[0] = Math.sqrt(d1);
                    roots[1] = -roots[0];
                } else {
                    roots[0] = Math.sqrt(d2);
                    roots[1] = -roots[0];
                }
            }
        }
        System.out.println(result);
        output(roots);
    }

    static double[] setRoots(double[] roots, int start, double value) {
        roots[start] = Math.sqrt(value);
        roots[start + 1] = -roots[start];
        return roots;
    }

    static double[] setRoots(double[] roots, int start, double value, int pow) {
        for (int i = 0; i < pow; i++) {
            roots = setRoots(roots, 0, value);
        }
        return roots;
    }

    static byte getRootsCount(double d) {
        if (checkPositive(d)) {
            return 2;
        } else return 0;
    }

    static double[] initRoots(int count) {
        return new double[count];
    }

    static void output(double[] roots) {
        if (roots.length == 0) {
            System.out.println("Корней нет");
        } else {
            for (int i = 0; i < roots.length; i++) {
                System.out.println("Корень " + (i + 1) + ":" + roots[i]);
            }
        }
    }


    static double diskr(int a, int b, int c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    static boolean checkPositive(double d) {
        return d >= 0;
    }
}
