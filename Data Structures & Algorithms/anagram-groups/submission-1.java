class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var result = new HashMap<String, List<String>>();
        for(int i=0; i< strs.length; i++){
            var copy = strs[i].toCharArray();
            Arrays.sort(copy);
            if(result.containsKey(new String(copy))){
                var existing = result.get(new String(copy));
                existing.add(strs[i]);
                result.put(new String(copy), existing);
            }else{
                var list = new ArrayList<String>();
                list.add(strs[i]);
                result.put(new String(copy), list);
            }
        }
        return result.values().stream().toList();
    }

}
