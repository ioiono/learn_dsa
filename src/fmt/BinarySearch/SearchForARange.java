package fmt.BinarySearch;

import java.util.Arrays;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);

        if (res < 0) return new int[]{-1, -1};

        int left = res;
        int right = res;
        System.out.println(res);
        while (left >= 1 && nums[left - 1] == target) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};


    }

    public static void main(String[] args) {
        int[] ints = new int[]{1};
        SearchForARange sa = new SearchForARange();
        System.out.println(Arrays.toString(sa.searchRange(ints, 1)));
    }
}
