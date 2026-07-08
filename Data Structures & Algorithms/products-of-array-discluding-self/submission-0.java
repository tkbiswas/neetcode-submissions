class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                else {
                    product = product * nums[j];
                    if (nums[j] == 0) break;
                }
            }
            result[i] = product;
        }
        return result;
    }
}  
