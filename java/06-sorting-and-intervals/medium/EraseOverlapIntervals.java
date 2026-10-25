// Time = O(n*log(n))   ,   Space = O(1)
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res=0;
        Arrays.sort(intervals, (a, b) -> {
        if (a[0] != b[0])   return Integer.compare(a[0], b[0]);
        return Integer.compare(a[1], b[1]);
        });
        int end=intervals[0][1];
        for(int i=1; i<intervals.length;i++){
            if (intervals[i][0]>=end)   end=intervals[i][1];
            else {res++;    end=Math.min(end,intervals[i][1]);}
        }
        return res;
    }
}
