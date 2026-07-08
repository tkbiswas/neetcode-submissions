class Solution {
    public int[] twoSum(int[] nums, int target) {
        var indices = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            indices.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            var diff = target - nums[i];
            if(indices.containsKey(diff) && indices.get(diff) != i){
                return new int[]{i, indices.get(diff)};
            }
        }
        
        return new int[]{};

    }
}
