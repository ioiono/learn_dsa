package dsa.preface.java;

import java.util.*;

public class Tencent {

    private static int cnt;

    public static void canWin(int count, String[] strs) {
        for (int i = 0; i < count; i++) {
            if (canWin(strs[i])) {
                System.out.println("Yes,you can win!");
            } else {
                System.out.println("Oh,no.");
            }
        }
    }


    public static boolean canWin(String str) {
        List<Character> list = new ArrayList<>();
        cnt = 0;
        for (char ch : str.toCharArray()) {
            list.add(ch);
        }

        while (hasDups(list)) removeDups(list);

        return cnt % 2 != 0;
    }

    private static boolean hasDups(List<Character> list) {
        for (int i = 1; i < list.size(); i++) {
            char cur = list.get(i);
            char last = list.get(i - 1);
            if (cur == last) {
                return true;
            }
        }
        return false;
    }

    private static void removeDups(List<Character> list) {
        for (int i = 1; i < list.size(); i++) {
            char last = list.get(i - 1);
            char cur = list.get(i);
            if (cur == last) {
                list.remove(i - 1);
                list.remove(i - 1);
                cnt++;
                i--;
            }
        }
    }


    public static void main(String[] args) {
                canWin(4, new String[]{"1234432", "112233","11","12332",});
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        String[] strs = new String[a];
//        for (int i = 0; i < a; i++) {
//            strs[i] = in.next();
//        }
//
//        canWin(a, strs);

    }
}
