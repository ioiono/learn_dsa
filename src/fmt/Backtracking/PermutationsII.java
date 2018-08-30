package fmt.Backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    // sorting !
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // ps here check for itself and its previous element,
            // when a number has the same value with its previous, we can use this number only if his previous is used
            //
            // Another explanation for why both
            //
            // 1. if(i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) continue;
            // and
            //
            // 2. if(i > 0 && nums[i] == nums[i - 1] && use[i - 1]) continue;
            // work is given below:
            //
            // The problem for Permutation II is that different orders of duplicates should only be considered as one permutation. In other words, you should make sure that when these duplicates are selected, there has to be one fixed order.
            //
            // Now take a look at code 1 and 2.
            //
            // Code 1 makes sure when duplicates are selected, the order is ascending (index from small to large). However, code 2 means the descending order.﻿
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }

    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        System.out.println(p.permuteUnique(new int[]{1, 2, 3, 3}));
    }

}
