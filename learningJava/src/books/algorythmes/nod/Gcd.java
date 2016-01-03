package books.algorythmes.nod;

public class Gcd {
    public static void main(String[] args) {
        System.out.println(gcd(9, 4));
        System.out.println(nok(432, 111));
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static int nok(int p, int q) {
        return p * q / gcd(p, q);
    }
}
