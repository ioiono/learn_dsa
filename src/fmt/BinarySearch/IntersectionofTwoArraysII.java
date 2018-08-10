package fmt.BinarySearch;

import java.util.*;

public class IntersectionofTwoArraysII {
    // O(nlgn)
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int aNums1 : nums1) {
            if (map.containsKey(aNums1)) map.put(aNums1, map.get(aNums1) + 1);
            else map.put(aNums1, 1);
        }

        for (int aNums2 : nums2) {
            if (map.containsKey(aNums2) && map.get(aNums2) > 0) {
                result.add(aNums2);
                map.put(aNums2, map.get(aNums2) - 1);
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 2, 1};
        int[] n2 = new int[]{2};
        System.out.println(Arrays.toString(new IntersectionofTwoArraysII().intersect(n1, n2)));
    }
}
