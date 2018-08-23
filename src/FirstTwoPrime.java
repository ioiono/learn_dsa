public class FirstTwoPrime {
    public static boolean isPrimeNumber(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 1000000; cnt != 2; i++) {
            if (isPrimeNumber(i) && isPrimeNumber(sumOfDigits(i))) {
                cnt++;
                System.out.println(i);
            }
        }
    }
}
