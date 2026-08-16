class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;
        var heap = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            heap.offer(stone);
        }

      while(!heap.isEmpty()) {
            if (heap.size() == 1)
                return heap.poll();
            int x = heap.poll();
            int y = heap.poll();
            if (x - y > 0)
                heap.offer(x - y);
        }
        return 0;
    }
}
