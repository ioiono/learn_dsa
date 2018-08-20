package fmt.HashTable;

import java.util.HashSet;
import java.util.Set;

public class JewelsandStones {
    /**
     * @param J: the types of stones that are jewels
     * @param S: representing the stones you have
     * @return how many of the stones you have are also jewels
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        // replace all non-from-J characters from S, then compute its' length
        return S.replaceAll("[^" + J + "]", "").length();
    }

    /**
     * @param J: the types of stones that are jewels
     * @param S: representing the stones you have
     * @return how many of the stones you have are also jewels
     */
    public int numJewelsInStonesII(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }
        int counter = 0;
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                counter++;
            }
        }
        return counter;
    }

    public int numJewelsInStonesMy(String J, String S) {
        int res = 0;
        Set<Character> js = new HashSet<>();
        for (char ch : J.toCharArray()) {
            js.add(ch);
        }
        for (char ch : S.toCharArray()) {
            if (js.contains(ch)) res++;
        }
        return res;
    }
}
