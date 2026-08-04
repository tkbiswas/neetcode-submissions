class Solution {
    public int climbStairs(int n) {
        var map = new HashMap<Integer, Integer>();
        return recursion(map, n);
    }
    private int recursion(Map<Integer, Integer> map, int i){
        if(i <=1 ) return 1;
        if(map.containsKey(i)){
            return map.get(i);
        }

        int sum =  recursion(map, i-1) + recursion(map,i-2);
        map.put(i, sum);
        return sum;

    }
}
