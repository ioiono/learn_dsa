package fmt.Array;

import java.util.Arrays;

public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int k = A[0].length;
        int[][] res = new int[k][A.length];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < A.length; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ori = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(new TransposeMatrix().transpose(ori)));
    }
}
