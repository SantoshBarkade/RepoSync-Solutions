import java.util.*;

public class Solution {

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        
        ArrayList<Interval> result = new ArrayList<>();
        
       
        if (intervals == null || intervals.size() == 0) return result;

        
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        
        Interval current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);

           
            if (next.start <= current.end) {
               
                current.end = Math.max(current.end, next.end);
            } else {
                result.add(current);
                current = next;
            }
        }

       
        result.add(current);

        return result;
    }
}