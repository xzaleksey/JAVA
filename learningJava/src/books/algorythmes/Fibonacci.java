package books.algorythmes;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(findN(10));
    }

    public static long findN(int n) {
        return Math.round(Math.pow(((1 + Math.sqrt(5)) / 2), n) / Math.sqrt(5));
    }
}
