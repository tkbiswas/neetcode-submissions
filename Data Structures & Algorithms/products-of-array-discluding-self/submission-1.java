class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int product = 1;
        for (int num : nums) {
            if (num == 0) {
                zeroCount += 1;
            } else {
                product = product * num;
            }
        }
        if (zeroCount > 1) {
            return new int[nums.length];
        }

        if (zeroCount == 1) {
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    result[i] = product;
                    break;
                }

            }
            return result;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = product / nums[i];
        }
        return result;
    }
    
}  
