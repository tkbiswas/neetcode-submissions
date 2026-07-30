class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        var exists = new HashSet<Character>();
        int result =1;
        int left=0, right =1;
        exists.add(s.charAt(left));
        while(right < s.length()){
            if(!exists.contains(s.charAt(right))){
                exists.add(s.charAt(right));
                right++;
                result = Math.max(result, right-left);
            }else{
                while(s.charAt(left) != s.charAt(right)){
                    exists.remove(s.charAt(left));
                    left++;
                }
                left++;
                right++;
                result = Math.max(result, right-left);
            }
        }
return result;
    }
}
