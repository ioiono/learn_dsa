//Definition for an interval.
function Interval(start, end) {
  this.start = start;
  this.end = end;
}

/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
const merge = intervals => {
  intervals.sort((a, b) => a.start - b.start);
  const res = [];
  intervals.map(x => {
    if (res.length === 0 || x.start > res[res.length - 1].end) {
      res.push(x);
    } else {
      res[res.length - 1].end = Math.max(res[res.length - 1].end, x.end);
    }
  });
  return res;
};