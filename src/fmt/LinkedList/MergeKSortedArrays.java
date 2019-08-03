package fmt.LinkedList;

import java.util.*;

class MergeNode {
    int val, x, y;
    public MergeNode(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }
}
public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {-1, 2, 5, 9},
                {5, 6, 8, 10},
                {1, 3, 17, 20}
        };
        MergeKSortedArrays m = new MergeKSortedArrays();
        System.out.println(m.mergekSortedArrays(arr));
        System.out.println(Arrays.toString(m.mergekSortedArrays2(arr)));
    }

    public int[] mergekSortedArrays2(int[][] arrays) {
        List<Integer> rst = new ArrayList<>();
        if (arrays == null || arrays.length == 0) return new int[0];


        // Faster
        // Somehow, slower: PriorityQueue<MergeNode> queue = new PriorityQueue<>(Comparator.comparing(a -> a.val));
        PriorityQueue<MergeNode> queue = new PriorityQueue<>(arrays.length,
                new Comparator<>() {
                    public int compare(MergeNode a, MergeNode b) {
                        return a.val - b.val;
                    }
                }
        );

        //init
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 0) {
                queue.offer(new MergeNode(arrays[i][0], i, 0));
            }
        }

        while (!queue.isEmpty()) {
            MergeNode MergeNode = queue.poll();
            rst.add(MergeNode.val);
            if (MergeNode.y < arrays[MergeNode.x].length - 1) {
                queue.offer(new MergeNode(arrays[MergeNode.x][MergeNode.y + 1], MergeNode.x, MergeNode.y + 1));
            }
        }

        int[] arrayResult = new int[rst.size()];
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = rst.get(i);
        }
        return arrayResult;
    }


    public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> rst = new ArrayList<>();
        if (arrays == null || arrays.length == 0) {
            return rst;
        }

        PriorityQueue<MergeNode> queue = new PriorityQueue<>(arrays.length,
                Comparator.comparingInt(a -> a.val)
        );

        //init
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 0) {
                queue.offer(new MergeNode(arrays[i][0], i, 0));
            }
        }

        MergeNode MergeNode;

        while (!queue.isEmpty()) {
            MergeNode = queue.poll();
            rst.add(MergeNode.val);
            if (MergeNode.y < arrays[MergeNode.x].length - 1) {
                queue.offer(new MergeNode(arrays[MergeNode.x][MergeNode.y + 1], MergeNode.x, MergeNode.y + 1));
            }
        }

        return rst;

    }
}
