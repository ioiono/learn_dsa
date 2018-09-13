package fmt.Array.problems;

import java.util.*;

public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start) {
                result.add(i);
            } else if (i.start > newInterval.end) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }

    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {

        List<Interval> all = new ArrayList<>();
        if (intervals.isEmpty()) {
            all.add(newInterval);
            return all;
        }
        for (Interval i : intervals) {
            if (newInterval != null && i.start > newInterval.start) {
                all.add(newInterval);
                newInterval = null;
            }
            all.add(i);
        }
        if (newInterval != null) {
            all.add(newInterval);
        }

        return this.merge(all);
    }

    public List<Interval> merge(List<Interval> intervals) {

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        Interval i0 = new Interval(1, 2);
        Interval i1 = new Interval(3, 5);
        Interval i2 = new Interval(6, 7);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(12, 16);

        Interval newI = new Interval(4, 8);

        List<Interval> intervals = new ArrayList<>(Arrays.asList(i0, i1, i2, i3, i4));
        InsertInterval i = new InsertInterval();
//        System.out.println(i.insert(intervals, newI));
        System.out.println(i.insert2(intervals, newI));
    }
}