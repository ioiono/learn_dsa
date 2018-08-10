package fmt.BinarySearch;

public class Templates {
    /**
     * Template #1 is the most basic and elementary form of Binary Search. It is the standard Binary Search Template
     * that most high schools or universities use when they first teach students computer science. Template #1 is used
     * to search for an element or condition which can be determined by accessing a single index in the Array.
     * <p>
     * Most basic and elementary form of Binary Search
     * <p>
     * Search Condition can be determined without comparing to the element's neighbors (or use specific elements around
     * it)
     * <p>
     * No post-processing required because at each step, you are checking to see if the element has been found. If you
     * reach the end, then you know the element is not found
     *
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // End Condition: left > right
        return -1;
    }

    /**
     * Template #2 is an advanced form of Binary Search. It is used to search for an element or condition which requires
     * accessing the current index and its immediate right neighbor's index in the array.
     * <p>
     * Key Attributes:
     *
     * <p>
     * An advanced way to implement Binary Search.
     * <p>
     * Search Condition needs to access element's immediate right neighbor
     * <p>
     * Use element's right neighbor to determine if condition is met and decide whether to go left or right
     * <p>
     * Gurantees Search Space is at least 2 in size at each step
     * <p>
     * Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining
     * element meets the condition.
     * <p>
     * Distinguishing Syntax:
     * <p>
     * Initial Condition: left = 0, right = length-1
     * <p>
     * Termination: left > right
     * <p>
     * Searching Left: right = mid-1 Searching
     * <p>
     * Right: left = mid+1
     *
     * @param nums
     * @param target
     * @return
     */
    int binarySearchII(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (left != nums.length && nums[left] == target) return left;
        return -1;
    }

    /**
     * Template #3 is another unique form of Binary Search. It is used to search for an element or condition which
     * requires accessing the current index and its immediate left and right neighbor's index in the array.
     * <p>
     * Key Attributes:
     * <p>
     * An alternative way to implement Binary Search
     * <p>
     * Search Condition needs to access element's immediate left and right neighbors
     * <p>
     * Use element's neighbors to determine if condition is met and decide whether to go left or right
     * <p>
     * Gurantees Search Space is at least 3 in size at each step
     * <p>
     * Post-processing required. Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining
     * elements meet the condition.
     * <p>
     * Distinguishing Syntax:
     * <p>
     * Initial Condition: left = 0, right = length-1
     * <p>
     * Termination: left + 1 == right
     * <p>
     * Searching Left: right = mid
     * <p>
     * Searching Right: left = mid
     *
     * @param nums
     * @param target
     * @return
     */
    int binarySearchIII(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left + 1 == right
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 4, 5, 8, 9, 12};
        Templates t = new Templates();
        System.out.println(t.binarySearch(ints, 9));
        System.out.println(t.binarySearchII(ints, 9));
        System.out.println(t.binarySearchIII(ints, 9));
        System.out.println(true^true  ^ true ^ false);
    }
}
