package books.algorythmes.arrays;

import java.util.Arrays;

public class TransPosition {
    public static final int M = 4, N = 5;

    public static int[][] transArray(int[][] ints) {
        int m = ints[0].length;
        int n = ints.length;
        int[][] transInts = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transInts[i][j] = ints[j][m - i - 1];
            }
        }
        return transInts;
    }

    public static void main(String[] args) {
        int[][] ints = new int[M][N];
        int counter = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                ints[i][j] = counter++;
            }
        }
        System.out.println(Arrays.deepToString(ints));
        System.out.println(Arrays.deepToString(transArray(ints)));

    }
}
