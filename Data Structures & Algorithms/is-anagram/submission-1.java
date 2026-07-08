class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        var sSort = s.toCharArray();
        var tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);

    }
}
