package fmt.HashTable;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test0 = new int[]{2, 2, 1};
        int[] test1 = new int[]{4, 1, 2, 1, 2};
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(test0));
        System.out.println(sn.singleNumber(test1));
        System.out.println(sn.singleNumber(null));
    }
}
