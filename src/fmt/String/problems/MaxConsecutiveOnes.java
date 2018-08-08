package fmt.String.problems;

public class MaxConsecutiveOnes {
    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int num : nums) {
            if (num == 1) cur++;
            else cur = 0;

            if (cur > max) max = cur;
        }
        return max;
    }

    private static int findMaxConsecutiveOnes2(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
    }

    private static int findMaxConsecutiveOnes3(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            cnt = (num == 0) ? 0 : cnt + 1;
            res = Math.max(res, cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 0, 1, 1, 0, 1};
        int[] ints2 = new int[]{1};
        System.out.println(findMaxConsecutiveOnes(ints));
        System.out.println(findMaxConsecutiveOnes2(ints));
        System.out.println(findMaxConsecutiveOnes3(ints));

        System.out.println(findMaxConsecutiveOnes(ints2));
        System.out.println(findMaxConsecutiveOnes2(ints2));
        System.out.println(findMaxConsecutiveOnes3(ints2));
    }
}
