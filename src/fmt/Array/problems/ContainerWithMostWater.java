package fmt.Array.problems;

public class ContainerWithMostWater {
    // bf
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int cur = Math.min(height[j], height[i]) * (j - i);
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;

    }

    public int maxArea2(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
    // two pointer

    public int maxArea3(int[] height) {
        int max= 0;
        int lo = 0;
        int hi = height.length - 1;
        while (lo < hi) {
            max = Math.max(max, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] <= height[hi]) lo++;
            else hi--;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] ints = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater mostWater = new ContainerWithMostWater();
        System.out.println(mostWater.maxArea(ints));
        System.out.println(mostWater.maxArea2(ints));
        System.out.println(mostWater.maxArea3(ints));
    }
}
