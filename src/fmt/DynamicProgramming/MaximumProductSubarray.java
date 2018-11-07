package fmt.DynamicProgramming;


public class MaximumProductSubarray {
    // Brute-Force: Runtime: 134 ms, faster than 2.74%
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                max = Math.max(prod, max);
            }
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;    // global max
        int maxloc = 1, minloc = 1;     // max or min end here
        for (int num : nums) {          // negative could cause maxloc and minloc swap
            int prod1 = maxloc * num, prod2 = minloc * num;
            maxloc = Math.max(num, Math.max(prod1, prod2));
            minloc = Math.min(num, Math.min(prod1, prod2));
            max = Math.max(max, maxloc);
        }
        return max;
    }

    // two pass
    // it's really about odd negative numbers or even negative numbers, if it's odd, either the left end one or the
    // right end one should be counted, so it will be revealed by scanning from left and from right in 2 passes.
    public int maxProduct3(int[] nums) {
        int max = Integer.MIN_VALUE, product = 1;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            max = Math.max(product *= nums[i], max);
            if (nums[i] == 0) product = 1;
        }

        product = 1;
        for (int i = len - 1; i >= 0; i--) {
            max = Math.max(product *= nums[i], max);
            if (nums[i] == 0) product = 1;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -2, 4};
        System.out.println(new MaximumProductSubarray().maxProduct(arr));
        System.out.println(new MaximumProductSubarray().maxProduct2(arr));
        System.out.println(new MaximumProductSubarray().maxProduct3(arr));
    }
}
