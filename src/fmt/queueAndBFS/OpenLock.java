package fmt.queueAndBFS;

import java.util.*;

public class OpenLock {


    int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> dead = new HashSet<>();
        Collections.addAll(dead, deadends);

        if (dead.contains(start) || target == null) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String node = queue.poll();
                for (int i = 0; i < 4; i++) {
                    for (int j = -1; j <= 1; j += 2) {
                        char[] chars = node.toCharArray();
                        chars[i] = (char) (((chars[i] - '0') + j + 10) % 10 + '0');
                        String next = new String(chars);
                        if (next.equals(target)) {
                            steps++;
                            return steps;
                        }
                        if (dead.contains(next) || visited.contains(next)) {
                            continue;
                        }
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"8888"};
        String[] deadends2 = new String[]{"0201", "0101", "0102", "1212", "2002"};
        System.out.println(new OpenLock().openLock(deadends, "0009"));
        System.out.println(new OpenLock().openLock(deadends2, "0000"));
        System.out.println(new OpenLock().openLock(deadends2, null));
    }

}
