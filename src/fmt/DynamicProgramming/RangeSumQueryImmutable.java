package fmt.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// MLE...
//class NumArray {
//    private int[][] map;
//
//    public NumArray(int[] nums) {
//        if (nums.length == 0) {
//            this.map = new int[0][0];
//            return;
//        }
//        this.init(nums);
//    }
//
//    private void init(int[] nums) {
//        int n = nums.length;
//        this.map = new int[n][n];
//        // map[i][j] = map[i-1,j] + nums[i];
//        map[0][0] = 0;
//        for (int i = 0; i < map.length; i++) {
//            map[i][i] = nums[i];
//            for (int j = i + 1; j < map.length; j++) {
//                map[i][j] = map[i][j - 1] + nums[j];
//            }
//        }
//    }
//
//    public int[][] getMap() {
//        return map;
//    }
//
//    public int sumRange(int i, int j) {
//        return map[i][j];
//    }
//}
//class NumArray {
//    private Map<String, Integer> map = new HashMap<>();
//
//    public NumArray(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                map.put(i + ", " + j, sum);
//            }
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return map.get(i + ", " + j);
//    }
//}

//class NumArray {
//    private int[] sum;
//
//    public NumArray(int[] nums) {
//        sum = new int[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            sum[i + 1] = sum[i] + nums[i];
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return sum[j + 1] - sum[i];
//    }
//}

// Oct 27, 2018
// didn't remember this problem at all, sigh...
class NumArray {
    private HashMap<Integer, Integer> map;
    public NumArray(int[] nums) {
        this.map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(i, sum);
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return map.get(j);
        else return map.get(j) - map.get(i - 1);
    }
}
public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));
    }
}
