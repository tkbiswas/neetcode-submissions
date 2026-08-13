class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var heap = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
        List<Integer> res = new ArrayList<Integer>();
        for(int i =0; i< nums.length; i++){
            heap.offer(new int[]{nums[i], i});
            if(i >= k -1){
                while(heap.peek()[1] <= i-k ){
                    heap.poll();
                }
                res.add( heap.peek()[0]);
            }
        }
        return res.stream().mapToInt( a -> a.intValue()).toArray();
    }
}
