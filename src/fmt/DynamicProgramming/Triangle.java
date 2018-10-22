package fmt.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    // bottom-up
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);

        int n = triangle.size();
        int[] min = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) { // number of triangle.get(i)
                min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
            }
            System.out.println(Arrays.toString(min));
        }
        return min[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>(Arrays.asList(2)));
        t.add(new ArrayList<>(Arrays.asList(3, 4)));
        t.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        t.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(t));
        System.out.println(triangle.minimumTotal2(t));
    }

}
