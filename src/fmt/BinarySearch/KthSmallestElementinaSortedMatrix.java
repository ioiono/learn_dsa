package fmt.BinarySearch;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element
 * in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [ [ 1,  5,  9], [10, 11, 13], [12, 13, 15] ], k = 8,
 * <p>
 * return 13. Note: You may assume k is always valid, 1 ≤ k ≤ n2.
 */
class Tuple implements Comparable<Tuple> {
    int x, y, val;

    Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}

public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        // minHeap
        // Build a minHeap of elements from the first row.
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }

        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = pq.poll();
            if (tuple.x != len - 1) {
                pq.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
            }
        }
        return pq.poll().val;
    }

    // NAIVE SOLUTION WITH PQ

    public int kthSmallest2(int[][] matrix, int k) {
        // reverse order for smallest or largest...
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                while (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }

    // Runtime: 0 ms
    public int kthSmallest3(int[][] matrix, int k) {

        int l = matrix[0][0], r = matrix[matrix.length - 1][matrix[0].length - 1];

        while (l < r) {
            int m = l + (r - l) / 2;
            int amount = countNum(matrix, m); // count of nums that >= m
            if (amount >= k) {// find the smallest num that satisfies the condition which is make "amount >= k" true
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int countNum(int[][] matrix, int target) {
        int counter = 0, j = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (j >= 0 && matrix[i][j] > target) {
                j--;
            }
            counter += (j + 1);
        }
        return counter;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1, 5, 9},
                {3, 6, 13},
                {12, 13, 15},
        };
        int k = 3;
        KthSmallestElementinaSortedMatrix ks = new KthSmallestElementinaSortedMatrix();
        System.out.println(ks.kthSmallest(m, k));
        System.out.println(ks.kthSmallest2(m, k));
        System.out.println(ks.kthSmallest3(m, k));
    }
}
