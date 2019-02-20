package fmt.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    /**
     * Because we have two check every meeting with every other meeting, the total run time is O(n^2)
     * No additional space is used, so the space complexity is O(1).
     * @param intervals
     * @return
     *
     * 186 ms, faster than 5.24% of Java online submissions for Meeting Rooms.
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j])) return false;
            }
        }
        return true;
    }

    private boolean overlap(Interval i1, Interval i2) {
        return ((i1.start >= i2.start && i1.start < i2.end)
                || (i2.start >= i1.start && i2.start < i1.end));
    }

    /**
     * Time complexity : (nlogn). The time complexity is dominated by sorting. Once the array has been
     * sorted, only O(n) time is taken to go through the array and determine if there is any overlap.
     *
     * Space complexity : O(1). Since no additional space is allocated.
     * @param intervals
     * @return
     *
     * 5 ms, faster than 93.18% of Java online submissions for Meeting Rooms.
     */
    public boolean canAttendMeetings2(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
}
