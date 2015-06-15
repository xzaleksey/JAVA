package ru.geekbrains.practise.ksenia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfOnes {
    static int countOnes = 0;
    public static void main(String[] args) throws IOException {
        NumberOfOnes num = new NumberOfOnes();
        int result = num.count();
        System.out.println("Number of ones in binary representation: "+result);

    }
    public int count() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Number");
        int number = Integer.parseInt(reader.readLine());
        String result = Integer.toBinaryString(number);
        System.out.println(result);
        for (int i = 0; i<result.length(); i++){
            if (((Character.getNumericValue(result.charAt(i))))==1){
                countOnes+=1;

            }
        }return countOnes;

    }
}
