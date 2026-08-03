class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> (a[1]-a[0] - (b[1] - b[0])));
       for(int[] item : intervals){
         System.out.println(Arrays.toString(item));
       }
        var res = new int[queries.length];
        for(int i=0; i< queries.length; i++){
           for(int j=0; j< intervals.length; j++){
                if(intervals[j][0] <= queries[i] && queries[i] <= intervals[j][1]){
                    res[i] = intervals[j][1] - intervals[j][0] +1;
                    break;
                }
                res[i] = -1;
            }
        }
        return res;
    }
}
