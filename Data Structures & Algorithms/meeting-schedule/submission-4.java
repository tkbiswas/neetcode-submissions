/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
         if (intervals.isEmpty()) return true;
        List<Interval> sorted = intervals.stream().sorted(Comparator.comparingInt(a -> a.start)).collect(Collectors.toList());
        Interval last = sorted.get(0);
        for (int i = 1; i < sorted.size(); i++) {
            if (last.end > sorted.get(i).start) return false;
            else
                last = sorted.get(i);
        }
        return true;

    }
}
