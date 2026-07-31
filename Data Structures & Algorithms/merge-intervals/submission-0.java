class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int lastEnd = intervals[0][1];
        
        var res = new ArrayList<Integer[]>();
        for(int i=0; i< intervals.length; i++){
            if(res.isEmpty()){
                Integer[] temp = {intervals[0][0], intervals[0][1]};
                res.add(temp);
            }
            else if(intervals[i][0] > lastEnd ){
                 Integer[] temp = {intervals[i][0], intervals[i][1]};
                res.add(temp);
                lastEnd = intervals[i][1];
            }else{
                // get the last item from list 
                // new item is start or last item and max of old and new end
                lastEnd = Math.max(lastEnd, intervals[i][1]);
                Integer[] temp = {res.getLast()[0], lastEnd};
                res.removeLast();
                res.add(temp);
            }
        }
        int[][] result = res.stream()
                .map(arr -> Arrays.stream(arr).mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
       
        return result;
    }
}
