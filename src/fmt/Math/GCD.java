package fmt.Math;

public class GCD {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        GCD g = new GCD();

        System.out.println(g.gcd(12, 8));
    }
}
