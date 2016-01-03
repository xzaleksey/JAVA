package books.algorythmes.logarifm;

public class Logarifm {
    public static int getLg(int b) {
        if (b <= 0) return -1;
        if (b == 1) return 0;
        if (b == 2) return 1;
        int result = 2;
        int c = 2;
        do {
            result *= 2;
            c++;
        } while (result < b);
        return --c;
    }

    public static int exR1(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return exR1(a + a, b / 2);
        return exR1(a + a, b / 2) + a;
    }

    public static void main(String[] args) {
        int b = 1024;
        System.out.println(getLg(b));
        System.out.println(exR1(2, 25));
    }
}
