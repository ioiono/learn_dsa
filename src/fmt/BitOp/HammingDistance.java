package fmt.BitOp;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int res = 0, n = x ^ y;
        while (n != 0) {
            res++;
            n &= n - 1;
        }

        return res;
    }

    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count += xor & 1;
            xor = xor >> 1;
        }
        return count;
    }

    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1, 4));
        System.out.println(hd.hammingDistance2(1, 4));
        System.out.println(hd.hammingDistance3(1, 4));
    }
}

