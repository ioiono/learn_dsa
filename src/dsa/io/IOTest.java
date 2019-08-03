package dsa.io;

import java.util.*;

public class IOTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read two array
        // 5: 1 2 3 4 5
        // 4: 1 2 3 4

        // read two-dimension array
        // 5 3
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cur = scanner.nextInt();
                arr[i][j] = cur;
            }
        }

        System.out.println(Arrays.deepToString(arr));


    }


}
