package fmt.Math;

public class PowerofFour {
    public boolean isPowerOfFour(int num) {
        double res = Math.log(num) / Math.log(4);
        double ans = res - Math.floor(res);
        return ans == 0;
    }

    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }

    public static void main(String[] args) {
        PowerofFour pf = new PowerofFour();

        System.out.println(pf.isPowerOfFour(4));
        System.out.println(pf.isPowerOfFour(16));
    }
}
