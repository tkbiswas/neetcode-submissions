class Solution {
    public int rob(int[] nums) {
        var memo = new HashMap<Integer, Integer>();
        return sum(memo, nums, 0);
        
    }
    private int sum(Map<Integer, Integer> memo, int[] nums, int i){
        if(i >= nums.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        var sum = Math.max(sum(memo,nums, i+1), nums[i] + sum(memo,nums, i+2));
        memo.put(i, sum);
        return sum;
    }
}
