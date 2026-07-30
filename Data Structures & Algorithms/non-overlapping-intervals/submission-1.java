class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int lastEnd = intervals[0][1];
        int result =0;
        for(int i=1; i< intervals.length; i++){
            if(lastEnd <= intervals[i][0]){
                lastEnd = intervals[i][1];
            }else{
                result++;
                lastEnd = Math.min(lastEnd, intervals[i][1]);
            }
        }
        return result;
    }
}
