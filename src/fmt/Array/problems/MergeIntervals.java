package fmt.Array.problems;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public String toString() {
        return "[" + this.start + ", " + this.end + "]";
    }
}

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));

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
}
