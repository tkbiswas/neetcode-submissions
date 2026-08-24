class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int[] distinctNums = Arrays.stream(nums).distinct().toArray();
        int right = 1;
        int left = 0;
        int maxLength = distinctNums.length != 0 ? 1 : 0;
        for (int i = 0; i < distinctNums.length && right < distinctNums.length; i++) {
            if (Math.abs(distinctNums[right] - distinctNums[right - 1]) == 0) {
                right++;
                continue;
            }
            if (Math.abs(distinctNums[right] - distinctNums[right - 1]) == 1) {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                left = right;
                right++;
            }
        }
        return maxLength;
    }
}
