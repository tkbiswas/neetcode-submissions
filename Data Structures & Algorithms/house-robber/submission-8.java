class Solution {
    public int rob(int[] nums) {
        int memo1 =0, memo2=0;
        for(int i =0; i< nums.length; i++){
            int temp = Math.max(nums[i] + memo1, memo2);
            memo1= memo2;
            memo2=temp;
        }
        return memo2;
    }
}
