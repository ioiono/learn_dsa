package fmt.Greedy;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MeetingRoomsII {
    /**
     * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0; end = 0; }
     * Interval(int s, int e) { start = s; end = e; } }
     * <p>
     * Time Complexity: O(NlogN).
     * <p>
     * There are two major portions that take up time here. One is sorting of the array that takes O(NlogN) considering
     * that the array consists of NN elements. Then we have the min-heap. In the worst case, all N meetings will collide
     * with each other. In any case we have NN add operations on the heap. In the worst case we will have N extract-min
     * operations as well. Overall complexity being (NlogN) since extract-min operation on a heap takes O(logN). Space
     * Complexity: O(N) because we construct the min-heap and that can contain N elements in the worst case as described
     * above in the time complexity section. Hence, the space complexity is O(N).
     */

    public int minMeetingRooms2(Interval[] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<Interval>() {
                    public int compare(Interval a, Interval b) {
                        return a.start - b.start;
                    }
                });

        // Add the first meeting
        allocator.add(intervals[0].end);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i].start >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i].end);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }


    /**
     * Time Complexity: O(NlogN) because all we are doing is sorting the two arrays for start timings and end timings
     * individually and each of them would contain NN elements considering there are N intervals.
     * <p>
     * Space Complexity: O(N) because we create two separate arrays of size N, one for recording the start times and one
     * for the end times.
     *
     * @param intervals
     *
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        // Sort the intervals by end time
        Arrays.sort(
                end,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        // Sort the intervals by start time
        Arrays.sort(
                start,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        // The two pointers in the algorithm: e_ptr and s_ptr.
        int startPointer = 0, endPointer = 0;

        // Variables to keep track of maximum number of rooms used.
        int usedRooms = 0;

        // Iterate over intervals.
        while (startPointer < intervals.length) {

            // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
            if (start[startPointer] >= end[endPointer]) {
                usedRooms -= 1;
                endPointer += 1;
            }

            // We do this irrespective of whether a room frees up or not.
            // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
            // remain the same in that case. If no room was free, then this would increase used_rooms
            usedRooms += 1;
            startPointer += 1;

        }

        return usedRooms;
    }


}
