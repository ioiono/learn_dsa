package dsa.preface.java;

import java.util.*;

public class MS {

    public int findPosition(int input1, int input2, int[][] input3) {
        // Write code here...

        int peopleNum = input1;
        int queriesNum = input2;
        int[][] events = input3;

        int res = 0;

        List<String> list = new LinkedList<>();

        for (int i = 1; i <= peopleNum; i++) {
            list.add(i + "");
        }

        for (int[] event : events) {
            int type = event[0];
            int x = event[1];
            String str = "" + x;


            if (list.size() == 0) return res; // lol

            switch (type) {
                case 1:
                    list.remove(0);
                    break;
                case 2:
                    list.remove(str);
                    break;
                case 3:
                    int idx = -1;
                    idx = list.indexOf(str);
                    if (idx != -1) {
                        res += (idx + 1);
                    }
                    //                    for (int i = 0; i < list.size(); i++) {
                    //                        if (list.get(i).equals(str)) {
                    //                            res += (i + 1);
                    //                            break;
                    //                        }
                    //                    }

            }
        }


        return res;
    }

    public int points(int input, int[] input2) {
        int[] arr = input2;
        Map<Integer, Integer> map = new HashMap<>();
        int res = input2.length;

        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
            if (map.containsKey(el)) {
                int idx = map.get(el);
                if (i - idx > 2) {
                    res -= 2;
                } else if (i - idx == 1) {
                    res--;
                }
            } else {
                map.put(el, i);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        MS t = new MS();
        int[][] input3 = new int[][]{{1, 0}, {3, 3}, {2, 2}};
        int[][] test1 = new int[][]{{1, 0}};
        System.out.println(t.findPosition(5, 3, input3));
        System.out.println(t.findPosition(5, 1, test1));
    }
}
