package fmt.BinarySearch;

public class VersionControl {
    private final int FIRST_BAD_VERSION = 6;

    // mock API XD
    boolean isBadVersion(int version) {
        return version >= this.FIRST_BAD_VERSION;
    }
}
