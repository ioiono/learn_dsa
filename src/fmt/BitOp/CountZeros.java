package fmt.BitOp;

public class CountZeros {
    public int count(int n) {
        int res = 0;

        while ((n /= 10) != 0) {
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 1000_000_000;
        CountZeros c = new CountZeros();

        System.out.println(c.count(n));
    }
}
