class Solution {
    public int subarraySum(int[] nums, int k) {
        var prefixSum =  new HashMap<Integer, Integer>();
        int result = 0;
        int sum = 0;
        prefixSum.put(0, 1);
        for(int i=0; i< nums.length; i++){
            sum = sum + nums[i];
            int temp = sum - k;
            result = result + prefixSum.getOrDefault(temp,0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum,0) + 1);
            
        }
        return result;
    }
}