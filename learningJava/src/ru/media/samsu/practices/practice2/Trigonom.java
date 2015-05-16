package ru.media.samsu.practices.practice2;

public class Trigonom {
    public static final int RAD = 1, DEG = 2;

    public static double getSumSinuses(double[] angles, int type) {
        double sum = 0;
        for (double d : angles) {
            sum += Math.sin(getAngle(d, type));
        }
        return sum;
    }

    public static double getSumSinuses(double[] angles, int type, int digits) {
        return Math.round(getSumSinuses(angles, type) * Math.pow(10, digits)) / (Math.pow(10, digits));
    }

    public static double getSumCosinuses(double[] angles, int type) {
        double sum = 0;
        for (double d : angles) {
            sum += Math.cos(getAngle(d, type));
        }
        return sum;
    }

    public static double getSumCosinuses(double[] angles, int type, int digits) {
        return Math.round(getSumCosinuses(angles, type) * Math.pow(10, digits)) / (Math.pow(10, digits));
    }

    public static double getDifSinuses(double[] angles, int type) {
        double sum = 0;
        for (double d : angles) {
            sum -= Math.sin(getAngle(d, type));
        }

        return sum;
    }

    public static double getDifSinuses(double[] angles, int type, int digits) {
        return Math.round(getDifSinuses(angles, type) * Math.pow(10, digits)) / (Math.pow(10, digits));
    }

    public static double getDifCosinuses(double[] angles, int type) {
        double sum = 0;
        for (double d : angles) {
            sum -= Math.cos(getAngle(d, type));
        }
        return sum;
    }

    public static double getDifCosinuses(double[] angles, int type, int digits) {
        return Math.round(getDifCosinuses(angles, type) * Math.pow(10, digits)) / (Math.pow(10, digits));
    }

    public static double getMultSinuses(double[] angles, int type) {
        double sum = 0;
        for (double d : angles) {
            sum *= Math.sin(getAngle(d, type));
        }
        return sum;
    }

    public static double getMultSinuses(double[] angles, int type, int digits) {
        return Math.round(getMultSinuses(angles, type) * Math.pow(10, digits)) / (Math.pow(10, digits));
    }

    public static double getMultCosinuses(double[] angles, int type) {
        double sum = 0;
        for (double d : angles) {
            sum *= Math.cos(getAngle(d, type));
        }
        return sum;
    }

    public static double getMultCosinuses(double[] angles, int type, int digits) {
        return Math.round(getMultCosinuses(angles, type) * Math.pow(10, digits)) / (Math.pow(10, digits));
    }

    public static double getAngle(double d, int type) {
        return type == RAD ? d : Math.toRadians(d);
    }

    public static void main(String[] args) throws Exception {
        double[] angles = {Math.PI / 2, 0, Math.PI / 3};
        int type = 1;
        //int type = Integer.parseInt(args[0]);
//        double[] angles = {90,0,30};
        System.out.println("Сумма синусов :" + getSumSinuses(angles, type, 2));
        System.out.println("Сумма косинусов:" + getSumCosinuses(angles, type, 2));
        System.out.println("Разность синусов :" + getDifSinuses(angles, type, 2));
        System.out.println("Разность косинусов:" + getDifCosinuses(angles, type, 2));
        System.out.println("Произведение синусов :" + getMultSinuses(angles, type, 2));
        System.out.println("Произведение косинусов:" + getMultCosinuses(angles, type, 2));
    }
}
