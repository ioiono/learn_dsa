package fmt.BST;

// https://leetcode.com/problems/unique-binary-search-trees/description/
public class UniqueBinarySearchTrees {
    // O(N^2) O(N)
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    // Catalan number Cn
    // Time complexity : O(N), as one can see, there is one single loop in the algorithm.
    // Space complexity : O(1), we use only one variable to store all the intermediate results and the final one.
    public int numTreesMath(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
