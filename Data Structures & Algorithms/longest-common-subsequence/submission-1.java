class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == text2) return text1.length();
        int[][] memo = new int[text1.length()][text2.length()];
        for(int i=0; i<text1.length(); i++){
            for(int j=0; j<text2.length(); j++){
                memo[i][j] = -1;
            }
        }
        return max(memo, text1, text2, 0, 0);
    }

    private int max(int[][] memo, String t1, String t2, int i, int j){
        if(i >= t1.length() || j >= t2.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(t1.charAt(i) == t2.charAt(j)){
            memo[i][j] = 1 + max(memo, t1, t2, i+1, j+1);
            return  memo[i][j];
        }
         memo[i][j] = Math.max(max(memo, t1, t2, i+1, j), max(memo, t1, t2, i, j+1));
        return memo[i][j];
        

    }
}
