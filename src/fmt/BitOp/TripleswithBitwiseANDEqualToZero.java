package fmt.BitOp;

import java.util.HashMap;
import java.util.Map;

public class TripleswithBitwiseANDEqualToZero {
    public int countTriplets(int[] A) {
        int max = 0;
        for (int num : A) {
            max = Math.max(num, max);
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : A) {
            for (int b : A) {
                count.put(a & b, count.getOrDefault(a & b, 0) + 1);
            }
        }
        int res = 0;
        for (int a : A) {
            for (Map.Entry<Integer, Integer> c : count.entrySet()) {
                if ((c.getKey() & a) == 0) {
                    res += c.getValue();
                }
            }
        }
        return res;
    }

    // 37ms
    public int countTriplets2(int[] A) {
        int maxShift = 16;

        int[] count = new int[(1 << maxShift)];

        for (int a : A) {
            for (int b : A) {
                count[a & b]++;
            }
        }

        int result = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            for (int a : A)
                if ((i & a) == 0) result += count[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 3};
        System.out.println(new TripleswithBitwiseANDEqualToZero().countTriplets(A));
    }
}
