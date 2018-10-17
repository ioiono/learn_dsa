package fmt.Math;

public class ImplementRand10UsingRand7 {
    // generates a uniform random integer in the range 1 to 7
    private int rand7() {
        return 1 + (int) (Math.random() * 7);
    }

    public int rand10() {
        int index = Integer.MAX_VALUE;
        while (index > 40) {
            index = 7 * (rand7() - 1) + rand7();
        }

        return (index - 1) % 10 + 1;
    }

    // clean code
    public int rand10_2() {
        int res = 40;
        while (res >= 40) {
            res = 7 * (rand7() - 1) + rand7() - 1;
        }
        return res % 10 + 1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementRand10UsingRand7().rand10());
        System.out.println(new ImplementRand10UsingRand7().rand10());
        System.out.println(new ImplementRand10UsingRand7().rand10());
        System.out.println(new ImplementRand10UsingRand7().rand10());

        System.out.println(new ImplementRand10UsingRand7().rand7());
        System.out.println(new ImplementRand10UsingRand7().rand7());
        System.out.println(new ImplementRand10UsingRand7().rand7());
        System.out.println(new ImplementRand10UsingRand7().rand7());
        System.out.println(new ImplementRand10UsingRand7().rand7());
    }
}
