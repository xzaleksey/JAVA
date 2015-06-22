package books.algorythmes;

import ru.geekbrains.practise.sort.ASort;

public class FindSame {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(findSame(arr));
    }

    public static boolean findSame(int[] arr) {
        arr = ASort.sortMerge(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
