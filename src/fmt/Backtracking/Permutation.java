package fmt.Backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    // O(N!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) continue;       // O(N)
            list.add(num);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }


    List<List<Integer>> perms = new ArrayList<>();

    public List<List<Integer>> permute2(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return perms;
    }

    public void backtrack(int[] nums, List<Integer> tempList) {
        if (nums.length == tempList.size()) {
            perms.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if (tempList.contains(num)) continue; // skip previous elements
            tempList.add(num);
            backtrack(nums, tempList);
            tempList.remove(tempList.size() - 1);

        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutation p = new Permutation();
        System.out.println(p.permute(nums));
        System.out.println(p.permute2(nums));
    }
}
