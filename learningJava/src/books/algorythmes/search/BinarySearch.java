package books.algorythmes.search;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(5, new int[]{1, 2, 3, 4, 5}));

    }

    public static int binarySearch(int key, int[] a) {
        return binarySearch(key, a, 0, a.length - 1);
    }

    public static int binarySearch(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return binarySearch(key, a, lo, mid - 1);
        else if (key > a[mid]) return binarySearch(key, a, mid + 1, hi);
        else return mid;
    }

}
