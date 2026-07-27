class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var result = new ArrayList<Integer>();
        for (int i = 0; i <=nums.length - k; i++) {
            int[] copy = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(copy);
            result.add(copy[copy.length - 1]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
