public class Test {

    static void m(int... a) {
        System.out.println("1");
    }

    static void m(Integer... a) {
        System.out.println("2");
    }

    public static void main(String[] args) {
        int[] arr = StdIn.readAllInts();
        String s = "Равны";
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) s = "Не равны";
        }
        System.out.println(s);
    }
}