package fmt.array.problems;

import java.util.Arrays;

public class PlusOne {
    // from leetcode
    public static int[] plusOneRec(int[] digits) {
        return helper(digits, digits.length - 1);
    }

    private static int[] helper(int[] digits, int index) {
        if (digits[index] < 9) {
            digits[index]++;
            return digits;
        } else {
            if (index != 0) {
                digits[index] = 0;
                return helper(digits, index - 1);
            } else {
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                return res;
            }
        }
    }

    // from leetcode
    public static int[] plusOne1(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static int[] plusOne(int[] digits) {
        boolean flag = false;

        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (flag) {
                digits[i]++;
            }
            int num = digits[i];
            if (num >= 10) {
                flag = true;
                digits[i] = num % 10;
                if (i == 0) {
                    int[] dest = new int[digits.length + 1];
                    dest[0] = 1;
                    return dest;
                }
            } else {
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println();
        int[] ints = new int[]{1, 9, 8};
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(plusOne(ints)));
        System.out.println(Arrays.toString(plusOne1(ints)));
        System.out.println(Arrays.toString(plusOneRec(ints)));

    }
}
