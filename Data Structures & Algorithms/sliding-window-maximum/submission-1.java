class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int left =0, right = left + k;
        while(right < nums.length+1){
            int[] copy = Arrays.copyOfRange(nums,left, right);
            Arrays.sort(copy);
            res[left] = copy[copy.length -1];
            left++;
            right++;
        }
        return res;
    }
}
