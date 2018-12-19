package fmt.Math;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random ran = new Random();
        int min = 5;
        int max = 10;
        // [min, max]
        int x = ran.nextInt(max - min + 1) + min;
        System.out.println(x);
    }
}
