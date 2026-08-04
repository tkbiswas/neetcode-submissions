class Solution {
   public int minCostClimbingStairs(int[] cost) {
    var memo = new HashMap<Integer, Integer>();
        return Math.min(sum(memo, cost, 0), sum(memo, cost, 1));
    }

    private int sum(Map<Integer, Integer> memo, int[] cost, int index) {
        if(index >= cost.length) return 0;
        if(memo.containsKey(index)) return memo.get(index);
        int sum =  cost[index] + Math.min(sum(memo, cost, index +1), sum(memo,cost, index +2));
        memo.put(index, sum);
        return sum;
    }
}
