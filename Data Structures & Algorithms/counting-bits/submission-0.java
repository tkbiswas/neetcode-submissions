class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] =0;
        int offset = 1;
        for(int i =1; i<=n; i++){
            if(i == offset * 2 )
                offset = i;
            res[i] = 1 + res[i-offset];
        }
        return res;
    }
}
