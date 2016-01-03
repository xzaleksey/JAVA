package books.algorythmes.math;

import books.algorythmes.logarifm.Logarifm;

public class Fact {
    public static int getFact(int n) {
        if (n == 1) return 1;
        return n * getFact(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(Logarifm.getLg(getFact(5)));
    }
}
