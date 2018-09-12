package fmt.QueueAndBFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TaskScheduler {
    // clean code
    public int leastInterval(char[] tasks, int n) {
        //arrange the task with the highest frequency first
        //and insert the rest of the lower frequency task into the gap
        //for example
        //eg1:
        //A 3 B 2 C 1   n = 3
        //ABC-AB--A
        //(freq-1) * (n+1) + 1
        //eg2:
        //A 3 B 3 C 3,  n = 3
        //ABC-ABC-ABC
        //(freq-1) * (n+1) + 3
        //eg3:
        //A 2 B 2 C 2 n =1
        //ABCABC  (ABABC-C)XX not good
        //if there is no remaining slot for insertion, then insert to each block evenly
        // in this case, return input array's length

        int[] c = new int[26];
        for (char t : tasks) {
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while (i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }

    class Task {
        public int count, c;

        Task(int c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public int leastInterval2(char[] tasks, int n) {
        if (tasks == null) return 0;

        // Prepare priority queue of Task
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.count != b.count ? b.count - a.count : a.c - b.c);
        int[] taskCount = new int[26];
        for (char c : tasks) taskCount[c - 'A']++;
        for (int i = 0; i < taskCount.length; i++) {
            if (taskCount[i] > 0) pq.offer(new Task(i, taskCount[i]));
        }

        // process queue and count for each section, where k = n + 1 slots
        int count = 0;
        while (!pq.isEmpty()) {
            int k = n + 1; // slots in on section
            Set<Task> tempSet = new HashSet<>();
            while (k > 0 && !pq.isEmpty()) {
                Task task = pq.poll();
                if (task.count > 1) {
                    task.count = task.count - 1;
                    tempSet.add(task);
                }
                count++;
                k--;
            }

            pq.addAll(tempSet); // add valid tasks back to pq
            if (pq.isEmpty()) break;
            count += k; // if k > 0, the sections are all filled
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
