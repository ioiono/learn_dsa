package fmt.Array.problems;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax && num < firstMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax && num < secondMax) {
                thirdMax = num;
            }
        }
        return (int) (thirdMax == Long.MIN_VALUE ? firstMax : thirdMax);
    }

    public static void main(String[] args) {

    }
}
