package fmt.JavaCollectionsUsage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MapInterfaceUsage {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(3, 20);
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue(10));

        System.out.println(map.remove(1));
        System.out.println(map.get(1));

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(3, 310);
        map2.put(7, 230);
        map.putAll(new HashMap<>(map2));
        System.out.println(map);


        int minGroupSize = 2;

        // Read words from file and put into a simulated multimap
        Map<String, List<String>> m = new HashMap<String, List<String>>();

        try {
            Scanner s = new Scanner(new File("data/dictionary.txt"));
            while (s.hasNext()) {
                String word = s.next();
                String alpha = alphabetize(word);
                List<String> l = m.get(alpha);
                if (l == null) {
                    m.put(alpha, l = new ArrayList<String>());
                }
                l.add(word);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        // Print all permutation groups above size threshold
        for (List<String> l : m.values())
            if (l.size() >= minGroupSize)
                System.out.println(l.size() + ": " + l);
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
