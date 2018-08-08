package fmt.BinarySearch;

public class TemplateI {
    /**
     * Template #1 is the most basic and elementary form of Binary Search. It is the standard Binary Search Template
     * that most high schools or universities use when they first teach students computer science. Template #1 is used
     * to search for an element or condition which can be determined by accessing a single index in the Array.
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

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 4, 5, 8, 9, 12};
        System.out.println(new TemplateI().binarySearch(ints, 9));
    }
}
