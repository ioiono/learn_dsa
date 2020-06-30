package fmt.Array.problems;

import java.util.Arrays;

public class ShuffleAnArray {
    private final int[] bak;
    private final int[] list;

    public ShuffleAnArray(int[] nums) {
        this.bak = nums.clone();
        this.list = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.bak;
    }

    private void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < this.list.length - 1; i++) {
            int tmpIdx = (int) (Math.random() * (this.list.length - i));
            this.swap(this.list, i, tmpIdx + i);
        }
        return this.list;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        ShuffleAnArray sa = new ShuffleAnArray(ints);
        System.out.println(Arrays.toString(sa.shuffle()));
    }
}
