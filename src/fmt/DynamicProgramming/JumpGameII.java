package fmt.DynamicProgramming;

public class JumpGameII {

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


    public static void main(String[] args) {

    }
}
