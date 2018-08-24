package fmt.DynamicProgramming;

public class JumpGame {

    /**
     * Time complexity : O(2^n). Space complexity : O(n). ​​
     *
     * @param nums
     *
     * @return
     */
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }


    public boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    // sample 4 ms submission...
    public boolean canJumpII(int[] nums) {
        int step = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] >= step) {
                step = 0;
            }
            step++;
        }
        return nums[0] >= step;
    }

    public boolean canJumpFivems(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        if (nums[0] == 0) return false;
        int reach = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (i > reach || reach >= n - 1) {
                break;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= n - 1;
    }
    // clean code
    public boolean canJumpSixms(int[] nums) {
        int max = 0; // furthest you can jump to
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 4};
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(arr1));
    }

}
