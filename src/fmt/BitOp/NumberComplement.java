package fmt.BitOp;

public class NumberComplement {
    int highestOneBit(int i) {
        // HD, Figure 3-1
        System.out.println(Integer.toBinaryString(i));
        i |= (i >>  1);
        System.out.println(Integer.toBinaryString(i));
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
        System.out.println(Integer.toBinaryString(i - (i >>> 1)));
        return i - (i >>> 1);
    }

    public int findComplement(int num) {
        return ~num & (highestOneBit(num) - 1);
    }

    public static void main(String[] args) {
        NumberComplement nc = new NumberComplement();
        System.out.println(nc.findComplement(5));
    }
}
