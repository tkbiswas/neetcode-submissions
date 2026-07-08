class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var counts = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++){
            if(counts.containsKey(nums[i])){
                counts.put(nums[i], counts.get(nums[i])+1);
            }else{
                counts.put(nums[i], 1);
            }
        }
        var result = new int[counts.entrySet().size()][2];
        int i=0;
        var entrySet = counts.entrySet();
        
        for(var entry : entrySet){
            result[i][0]= entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }
        Arrays.sort(result, Comparator.comparingInt(a -> a[1]));
        var r = Arrays.stream(result).mapToInt(row -> row[0]).toArray();
        return Arrays.copyOfRange(r,r.length-k,r.length);
    }
}
