package fmt.Array.problems;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int[] arr = new int[matrix.length * matrix[0].length];
        int idx = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[idx++] = matrix[i][j];
            }
        }

        return -1 != binarySearch(arr, target);
    }

    private int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int min = matrix[0][0];
        int max = matrix[m - 1][n - 1];
        if (target < min || target > max) return false;

        int l = 0;
        int r = m * n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int x = (mid) / n;
            int y = (mid) % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return matrix[l / n][l % n] == target;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
        Searcha2DMatrix s = new Searcha2DMatrix();
        System.out.println(s.searchMatrix(m, 3));
        System.out.println(s.searchMatrix(m, 13));

    }


}
