package ru.geekbrains.practise.amazon;

import java.util.HashMap;

public class Amazon {
    public static void main(String[] args) {
        findSum2(new int[]{1, 1, 3, 4, 6, 7, 0}, 3);

    }

//    public static void findSum(int[] arr, int sum) {
//        arr = ASort.sortMerge(arr);
//        for (int i = 0; i < arr.length - 1; i++) {
//            int value = sum - arr[i];
//            int found;
//            if ((found = binarySearch(arr, value, i)) != -1) {
//                System.out.println(arr[i] + " " + arr[found]);
//                return;
//            }
//        }
//        System.out.println("Не найдено");
//    }
//
//    public static int binarySearch(int[] arr, int value, int current)
//
//    {
//        if (arr.length == 0 || arr[0] > value || arr[arr.length - 1] < value) {
//            return -1;
//        } else if (arr[0] == value) {
//            return arr[0];
//        } else if (arr[arr.length - 1] == value) {
//            return arr.length - 1;
//        }
//
//        int found = binarySearch(arr, value, 0, arr.length - 1);
//        if (found == current) {
//            if (arr[found - 1] == value && found > 0) {
//                found--;
//            } else if (arr[found + 1] == value && found < arr.length - 1) {
//                found++;
//            } else found = -1;
//        }
//        return found;
//    }

//    static int binarySearch(int[] arr, int value, int lo, int hi) {
//        if (lo > hi) return -1;
//        int mid = lo + (hi - lo) / 2;
//
//        if (value < arr[mid]) {
//            return binarySearch(arr, value, lo, mid - 1);
//        } else if (value > arr[mid]) {
//            return binarySearch(arr, value, mid + 1, hi);
//        } else {
//            return mid;
//        }
//
//    }

    public static void findSum2(int[] arr, int sum) {
        HashMap<Integer, Boolean> map = new HashMap(arr.length);
        Boolean temp;
        for (int i : arr) {
            temp = map.get(i);
            if (temp == null)
                map.put(i, false);
            else if (!temp) map.put(i, true);
        }
        for (int i : map.keySet()) {
            int found = sum - i;
            temp = map.get(found);
            if (temp != null) {
                if (i != found || (i == found && temp)) {
                    System.out.println(i + " " + found);
                    return;
                }
            }
        }
        System.out.println("Не найдено!");
    }
}
