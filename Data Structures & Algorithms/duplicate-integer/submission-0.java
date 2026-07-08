
class Solution {
    public boolean hasDuplicate(int[] nums) {
        var counts = new HashMap<Integer,Integer>();
        for(int i=0; i < nums.length; i++){
            if(counts.containsKey(nums[i])){
                return true;
            }else{
                counts.put(nums[i],1);
            }
           
        }
         return false;
    }
}