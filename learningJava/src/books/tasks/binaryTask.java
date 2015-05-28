package books.tasks;

public class binaryTask {
    static int count = 24, x = 3, y = 5;

    public static void main(String[] args) {
        if (x > y) { //делаем x минимальным
            x = x ^ (y = y ^ x);
            y = x ^ y;
        }
        int now, j = y;
        int min = 0, max = (count - 1) * y;
        while (max != min) {
            now = (min + max) / 2;
            j = now / x + now / y;
            if (j < count - 1) {
                min = now + 1;
            } else max = now;

        }
        System.out.println(x + max);
    }

}
