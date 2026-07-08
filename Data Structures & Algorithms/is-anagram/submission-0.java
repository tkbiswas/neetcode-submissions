class Solution {
    public boolean isAnagram(String s, String t) {
        var arr1 = s.toCharArray();
        var arr2 = t.toCharArray();
        if(arr1.length != arr2.length){
            return false;
        }
        var counts = new HashMap<Character, Integer>(0);
        for(int i=0; i< arr1.length; i++){
            if(counts.containsKey(arr1[i])){
                counts.put(arr1[i], counts.get(arr1[i])+1);
            }else{
                counts.put(arr1[i], 1);
            }
        }
        for(int i=0; i< arr2.length; i++){
            if(counts.containsKey(arr2[i])){
                counts.put(arr2[i], counts.get(arr2[i])-1);
            }else{
                return false;
            }
        }
        var mapValues = counts.values();
        for(Integer value : mapValues){
            if(value != 0){
               return false;
            }
        }
        return true;

    }
}
