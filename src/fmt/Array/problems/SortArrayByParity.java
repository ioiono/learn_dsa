package fmt.Array.problems;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByParity {
    // O(N) O(1)
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] % 2 == 0) {
                i++;
            }
            // odd
            if (i < j && nums[j] % 2 != 0) {
                j--;
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        return nums;
    }

    /**
     * Approach 1: Sort Intuition and Algorithm
     * <p>
     * Use a custom comparator when sorting, to sort by parity.
     * <p>
     * Complexity Analysis
     * <p>
     * Time Complexity: O(NlogN), where NN is the length of A.
     * <p>
     * Space Complexity: O(N) for the sort, depending on the built-in implementation of sort.
     *
     * @param A
     *
     * @return
     */
    public int[] sortArrayByParity2(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];

        Arrays.sort(B, Comparator.comparingInt(a -> a % 2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;

        /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
    }

    /**
     * Approach 2: Two Pass Intuition and Algorithm
     * <p>
     * Write all the even elements first, then write all the odd elements.
     * <p>
     * Complexity Analysis
     * <p>
     * Time Complexity: O(N), where NN is the length of A.
     * <p>
     * Space Complexity: O(N), the space used by the answer.
     *
     * @param A
     *
     * @return
     */
    public int[] sortArrayByParity3(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }
}
