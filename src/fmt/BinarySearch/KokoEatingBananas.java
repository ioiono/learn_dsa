package fmt.BinarySearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = 1000000000;
        while (l < r) {
            int m = (l + r) / 2, total = 0;
            for (int p : piles) total += ((p - 1) / m + 1);
            if (total <= H) { // find the first value that make total smaller than or equal to H
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * Complexity Analysis
     *
     * Time Complexity: O(NlogW), where N is the number of piles, and W is the maximum size of a pile.
     *
     * Space Complexity: O(1).
     * @param piles piles
     * @param H hour
     * @return min eating speed
     */
    public int minEatingSpeed2(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (possible(piles, H, mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo;
    }

    // Can Koko eat all bananas in H hours with eating speed K?
    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p : piles)
            time += (p - 1) / K + 1;
        return time <= H;
    }

    public static void main(String[] args) {
        int[] piles0 = new int[]{3, 6, 7, 11};
        int H0 = 8;
        int[] piles1 = new int[]{30, 11, 23, 4, 20};
        int H1 = 5;
        int[] piles2 = new int[]{30, 11, 23, 4, 20};
        int H2 = 6;

        KokoEatingBananas kk = new KokoEatingBananas();
        System.out.println(kk.minEatingSpeed(piles0, H0));
        System.out.println(kk.minEatingSpeed(piles1, H1));
        System.out.println(kk.minEatingSpeed(piles2, H2));
        System.out.println(kk.minEatingSpeed2(piles0, H0));
        System.out.println(kk.minEatingSpeed2(piles1, H1));
        System.out.println(kk.minEatingSpeed2(piles2, H2));
    }
}
