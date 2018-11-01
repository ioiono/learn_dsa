package fmt.DynamicProgramming;

public class IncreasingTripletSubsequence {
    /**
     * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
     * <p>
     * Formally the function should:
     * <p>
     * Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return
     * false. Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,4,5] Output: true Example 2:
     * <p>
     * Input: [5,4,3,2,1] Output: false
     *
     * @param nums
     *
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x <= c1) {
                c1 = x;           // c1 is min seen so far (it's a candidate for 1st element)
            } else if (x <= c2) { // here when x > c1, i.e. x might be either c2 or c3
                c2 = x;           // x is better than the current c2, store it
            } else {              // here when we have/had c1 < c2 already and x > c2
                return true;      // the increasing subsequence of 3 elements exists
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } // update small if n is smaller than both
            else if (n <= big) {
                big = n;
            } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }

    public static void main(String[] args) {
        //        int[] ints = new int[]{1, 2, 3, 4, 5};
        int[] ints = new int[]{5, 6, 3, 4, 1, 2};
        IncreasingTripletSubsequence tri = new IncreasingTripletSubsequence();
        System.out.println(tri.increasingTriplet(ints));
    }
}
