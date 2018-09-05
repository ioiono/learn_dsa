package fmt.Backtracking;

import fmt.DynamicProgramming.PalindromicSubstrings;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    public boolean isPP(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if(!set.add(ch)) {
                set.remove(ch);
            }
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println(pp.isPP("code"));
        System.out.println(pp.isPP("aab"));
        System.out.println(pp.isPP("carerac"));
    }
}
