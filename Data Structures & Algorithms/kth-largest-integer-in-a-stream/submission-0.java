class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue();
        this.k = k;
        for(int i=0; i<nums.length; i++){
            this.heap.offer(nums[i]);
            if(this.heap.size() > k)
                this.heap.poll();
        }
    }
    
    public int add(int val) {
        this.heap.offer(val);
        if(this.heap.size() > k)
                this.heap.poll();
        return this.heap.peek();        
    }
}
