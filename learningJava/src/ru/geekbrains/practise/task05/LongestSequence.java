package ru.geekbrains.practise.task05;

import java.util.Arrays;

public class LongestSequence {
    public static void main(String[] args) {
        int arr[] = {5,1, 2, 3, 2, 1, 3, 1, 2, 6, 7, 8, 9, 10, 11,0,-1};

        System.out.println(Arrays.toString(getLongestSequence(arr)) );
    }

    static int[] getLongestSequence(int[] arr) {
        int counter = 1, previous = Integer.MIN_VALUE, maxSequence = 0;
        int start = 0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] >= previous) {
                counter++;
                if (i==arr.length-1){// сравнивает последний элент
                    if(maxSequence<counter){
                        maxSequence=counter;
                        start=i-counter+1;
                        break;
                    }
                }
            } else {
                if(maxSequence<counter){// если максимальная найденная послед меньше текущей
                    maxSequence=counter;
                    start=i-counter;
                }
                counter = 1;
            }
            previous = arr[i];
        }
        return Arrays.copyOfRange(arr,start,start+maxSequence);
    }
}
