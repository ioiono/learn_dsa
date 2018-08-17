package fmt.HashTable;

import java.util.*;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) {
            if (map.get(list2[i]) == null) continue;
            int j = map.get(list2[i]);
            if (i + j <= minSum) {
                if (i + j < minSum) {
                    res.clear();
                    minSum = i + j;
                }
                res.add(list2[i]); // i + j == minSum
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

    }

}
