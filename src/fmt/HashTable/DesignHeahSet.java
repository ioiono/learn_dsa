package fmt.HashTable;

public class DesignHeahSet {
    private boolean[] arr;
    DesignHeahSet() {
        this.arr = new boolean[1000000];
    }
    public void add(int x) {
        this.arr[x] = true;
    }

    public void remove(int i) {
        this.arr[i] = false;
    }

    public boolean contains(int i) {
        return this.arr[i];
    }

    public static void main(String[] args) {
        DesignHeahSet set = new DesignHeahSet();
        set.add(1);
        set.add(2);

        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println();
    }
}
