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

    public int firstBadVersion2(int n) {
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion();
        System.out.println(fbv.firstBadVersion(10));
    }
}
