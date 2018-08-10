package fmt.BinarySearch;

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 0;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (this.isBadVersion(mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo; // lo == hi
    }

//    // mock API XD
//    boolean isBadVersion(int version) {
//        return version >= this.FIRST_BAD_VERSION;
//    }

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion();
        System.out.println(fbv.firstBadVersion(10));
    }
}
