package fmt.DynamicProgramming;

public class JumpGameII {
    public int jump5ms(int[] nums) {
        int start = 0;
        int end = 1;
        int next = 0;
        int step = 0;
        while (end < nums.length) {
            for (int i = start; i < end; i++)
                next = Math.max(next, i + nums[i]);
            if (next < end)
                return -1;
            start = end;
            end = next + 1;
            step++;
        }
        return step;
    }

    public int jump6ms(int[] nums) {
        int[] results = new int[nums.length];
        int farthest = 0;
        int steps = 0;
        for (int index = 0; index < nums.length; index++) {
            //  if(index <= farthest){
            int newfarthest = Math.max(farthest, Math.min(nums[index] + index, nums.length - 1));
            for (int next = farthest + 1; next <= newfarthest; next++) {
                results[next] = results[index] + 1;
            }
            farthest = newfarthest;
            //}
        }
        return results[nums.length - 1];
    }

    //time : O(n) space : O(1) Greedy
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext, i + nums[i]);
            if (i == curMaxArea) {
                res++;
                curMaxArea = maxNext;
            }
        }
        return res;
    }

    /**
     * [2,3,1,1,4]
     * <p>
     * level = 2 cur = 2 max = 4 i = 1
     *
     * @param nums
     *
     * @return
     */
    // time : O(n)  space : O(1) BFS
    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int level = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        int i = 0;
        while (curMaxArea - i + 1 > 0) {           //nodes count of current level>0
            level++;
            for (; i <= curMaxArea; i++) {         //traverse current level , and update the max reach of next level
                maxNext = Math.max(maxNext, nums[i] + i);
                if (maxNext >= nums.length - 1) {  // if last element is in level+1,  then the min jump=level
                    return level;
                }
            }
            curMaxArea = maxNext;
        }
        return 0;
    }

    // O(N^2)
    public int jumpDP(int[] A) {
        // state
        int[] steps = new int[A.length];

        // initialize
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        // function
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }

        // answer
        return steps[A.length - 1];
    }

    public static void main(String[] args) {

    }
}
