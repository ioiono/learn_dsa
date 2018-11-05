package fmt.DynamicProgramming;

public class BurstBalloons {
    // Java D&C with Memoization
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }

    public int maxCoinsDP(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }

    public int maxCoinsDP2(int[] inums) {
        if (inums == null || inums.length == 0) return 0;
        //nums[0]---> 1 * nums[0] * right
        //nums[len-1] ---> left * nums[len-1] * 1
        //max
        int len = inums.length;
        int[][] dp = new int[len + 2][len + 2];

        int c = 1;
        int[] nums = new int[len + 2];
        for (int num : inums) nums[c++] = num;
        nums[0] = nums[len + 1] = 1;
        //distance is 0, the num itself
        //for (int i = 0; i < len+2; i++) dp[i][i] = nums[i];

        //dp[i] = dp[i-1] * nums[i] * dp[i+1]
        // left * cur * right + (left) left.left * cur * left.right + (right) right.left * cur * right.right
        //dp[k][k+1] = dp[k][k], so no need to do so, i begins from 2
        for (int i = 2; i < len + 2; i++) {
            //distance btw(l,r) from 1 to len+1
            //if i = len+1, left = 0[-1], right = len + 1[len]
            for (int left = 0; left < len + 2 - i; left++) {
                //<left,right> --> <0, 0 + i>, <1, 1+i>
                int right = left + i;
                helper(dp, nums, left, right);
            }
        }
        return dp[0][len + 1];
    }

    void helper(int[][] dp, int[] nums, int l, int r) {
        //assume, left and right are two adjacent
        //and there is only one balloon available btw l+1 to right-1
        int temp = nums[l] * nums[r]; //right and left of current burst
        for (int i = l + 1; i < r; i++) {
            //get max from dp[left] + cur + dp[right]
            //left and right includes i because i is last being removed
            dp[l][r] = Math.max(dp[l][r], temp * nums[i] + dp[l][i] + dp[i][r]);
        }
    }

    public static void main(String[] args) {
        int[] balloons = new int[]{3, 1, 5, 8};
        System.out.println(new BurstBalloons().maxCoins(balloons));
        System.out.println(new BurstBalloons().maxCoinsDP(balloons));
        System.out.println(new BurstBalloons().maxCoinsDP2(balloons));
    }
}
