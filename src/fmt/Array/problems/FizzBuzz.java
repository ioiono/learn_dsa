package fmt.Array.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }

    public List<String> fizzBuzz2(int n) {
        List<String> ret = new ArrayList<>(n);
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                ret.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                ret.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                ret.add("Buzz");
                buzz = 0;
            } else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }

    public List<String> fizzBuzz3(int n) {
        List<String> res = new LinkedList<>();
        int cnt3 = 3;
        int cnt5 = 5;
        for (int i = 1; i <= n; i++) {
            if (i == cnt3 && i == cnt5) {
                res.add("FizzBuzz");
                cnt3 += 3;
                cnt5 += 5;
            } else if (i == cnt3) {
                cnt3 += 3;
                res.add("Fizz");
            } else if (i == cnt5) {
                cnt5 += 5;
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));
        System.out.println(fizzBuzz.fizzBuzz2(15));
        System.out.println(fizzBuzz.fizzBuzz3(15));
    }
}
