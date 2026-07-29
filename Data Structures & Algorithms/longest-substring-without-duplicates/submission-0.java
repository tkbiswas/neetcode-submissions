class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        var covered = new HashSet<Character>();
        int left = 0, right = 0, result = 0;
        while (right < s.length()) {
            if (!covered.contains(s.charAt(right))) {
                covered.add(s.charAt(right));
                right++;
                result = Math.max(result, right - left);
            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    covered.remove(s.charAt(left));
                    left++;
                }
                covered.remove(s.charAt(left));
                left++;
                covered.add(s.charAt(right));
                right++;
            }
        }
        return result;
    }
}
