package ru.media.samsu.practices.practice1;


import java.io.IOException;

public class Calculate {
    public static int getSumNumbers(int[] ints) {
        int sum = ints[0];
        for (int i = 1; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum;
    }

    public static double getSumNumbers(double[] doubles) {

        double sum = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
            sum += doubles[i];
        }
        return sum;
    }

    public static int getMultNumbers(int[] ints) {
        int mult = ints[0];
        for (int i = 1; i < ints.length; i++) {
            mult *= ints[i];
        }
        return mult;
    }

    public static double getMultNumbers(double[] doubles) {
        double mult = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
            mult *= doubles[i];
        }
        return mult;
    }

    public static double getMinNumbers(int[] ints) {
        int min = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (min > ints[i]) {
                min = ints[i];
            }
        }
        return min;
    }

    public static double getMinNumbers(double[] doubles) {
        double min = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
            if (min > doubles[i]) {
                min = doubles[i];
            }
        }
        return min;
    }

    public static int getMaxNumbers(int[] ints) {
        int max = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (max < ints[i]) {
                max = ints[i];
            }
        }
        return max;
    }

    public static double getMaxNumbers(double[] doubles) {
        double max = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
            if (max < doubles[i]) {
                max = doubles[i];
            }
        }
        return max;
    }

    public static float getAvgNumbers(int[] ints) {
        return Calculate.getSumNumbers(ints) / ints.length;
    }

    public static double getAvgNumbers(double[] doubles) {
        return Calculate.getSumNumbers(doubles) / doubles.length;
    }

    public static String checkType(String[] strings) {
        if (checkInt(strings)) {
            return "int";
        } else if (checkDouble(strings)) {
            return "double";

        }
        return "error";
    }

    public static boolean checkInt(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            try {
                Integer.parseInt(strings[i]);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static int[] convertInt(String[] strings) {
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }

        return ints;
    }

    public static boolean checkDouble(String[] strings) {
        for (String s : strings) {
            try {
                Double.parseDouble(s);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public static double[] convertDouble(String[] strings) {
        double[] doubles = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            doubles[i] = Double.parseDouble(strings[i]);
        }
        return doubles;
    }

    public static void test(int[] numbers) {
        System.out.println(Calculate.getSumNumbers(numbers));
        System.out.println(Calculate.getMultNumbers(numbers));
        System.out.println(Calculate.getMaxNumbers(numbers));
        System.out.println(Calculate.getMinNumbers(numbers));
        System.out.println(Calculate.getAvgNumbers(numbers));
    }

    public static void test(double[] numbers) {
        System.out.println(Calculate.getSumNumbers(numbers));
        System.out.println(Calculate.getMultNumbers(numbers));
        System.out.println(Calculate.getMaxNumbers(numbers));
        System.out.println(Calculate.getMinNumbers(numbers));
        System.out.println(Calculate.getAvgNumbers(numbers));
    }

    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");*/
        String s = "";
        for (String arg : args) {
            s += arg + " ";
        }
        String[] input = s.trim().split(" ");
        String type = Calculate.checkType(input);


        if (type.equals("int")) {
            test(convertInt(input));
        } else if (type.equals("double")) {
            test(convertDouble(input));
        } else {
            System.out.println("Тип не соответствует");

        }

    }

}
