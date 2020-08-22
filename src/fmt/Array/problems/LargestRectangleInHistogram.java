package fmt.Array.problems;

import java.util.Arrays;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            for (int j = i; j < heights.length; j++) {
                height = Math.min(heights[j], height);
                int width = j - i + 1;
                max = Math.max(width * height, max);
            }
        }

        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int[] lessIdxLeft = new int[heights.length];
        int[] lessIdxRight = new int[heights.length];

        for (int i = 1; i < heights.length; i++) {
            int idx = i - 1;
            while (idx >= 0 && heights[idx] >= heights[i]) {
                idx--;
            }
            lessIdxLeft[i] = idx;
        }
        for (int i = 0; i < heights.length; i++) {
            int idx = i + 1;
            while (idx < heights.length && heights[idx] >= heights[i]) {
                idx++;
            }
            lessIdxRight[i] = idx;
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = lessIdxRight[i] - lessIdxLeft[i] - 1;
            max = Math.max(height * width, max);
        }

        return max;
    }

    public int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{0, 9};
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea(heights));
        System.out.println(l.largestRectangleArea2(heights));
        System.out.println(l.largestRectangleArea3(heights));
    }
}
