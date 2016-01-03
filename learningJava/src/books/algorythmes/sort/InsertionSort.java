package books.algorythmes.sort;

public class InsertionSort {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int arr[] = new int[50000];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[arr.length - i - 1] = i;
        }
        insertionSort(arr);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int prevKey = i - 1;
            int key = arr[i];
            while (prevKey >= 0 && arr[prevKey] > key) {
                arr[prevKey + 1] = arr[prevKey];
                prevKey--;
            }
            arr[prevKey + 1] = key;
        }
        return arr;
    }
}
