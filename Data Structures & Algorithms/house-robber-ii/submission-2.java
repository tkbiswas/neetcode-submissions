class Solution {
   private int[][] memo;
   public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        memo = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return Math.max(sum(nums, 0, 1), sum(nums,1, 0));
        
    }

    private int sum(int[] nums, int i, int flag){
        if(i >= nums.length || (flag == 1 && i == nums.length-1)) return 0;
        if(memo[i][flag] != -1) return memo[i][flag];
        int sum = Math.max(sum(nums, i+1, flag), nums[i] + sum(nums, i+2, flag | (i ==0 ? 1 : 0)));
        memo[i][flag] = sum;
        return sum;
    }
}
