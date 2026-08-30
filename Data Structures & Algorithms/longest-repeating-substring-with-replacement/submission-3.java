class Solution {
    public int characterReplacement(String s, int k) {
        var freq = new HashMap<Character, Integer>();

        int res  = 0, left =0, max =0;
        for(int right =0; right < s.length(); right ++){
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) +1);
            max = Math.max(max, freq.get(s.charAt(right)));
            while((right -left +1) - max > k){
                freq.put(s.charAt(left), freq.get(s.charAt(left)) -1);
                left++;
            }
            res = Math.max(res, right -left +1);
        }
        return res;
    }
}
