package books.algorythmes.sort;

public class SelectionSort {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int arr[] = new int[50000];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[arr.length - i - 1] = i;
        }
        selectionSort(arr);
        System.out.println(System.currentTimeMillis() - startTime);

    }
    public static int[] selectionSort(int[] numbers) {
        int min, temp;

        for (int index = 0; index < numbers.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < numbers.length; scan++)
                if (numbers[scan] < numbers[min])
                    min = scan;

            // Swap the values
            temp = numbers[min];
            numbers[min] = numbers[index];
            numbers[index] = temp;
        }
        return numbers;
    }
}
