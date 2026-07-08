class Solution {

    public String encode(List<String> strs) {
        String encoded = strs.stream().map(str -> str.length() + "#" + str).collect(Collectors.joining());
        System.out.println(encoded);
        return encoded;
    }

    public List<String> decode(String str) {
        var decoded = new ArrayList<String>();
        StringBuilder lenStr = new StringBuilder();
        for (int i = 0; i < str.length();) {
            if (str.charAt(i) != '#') {
                lenStr.append(str.charAt(i));
                i++;
            } else {
                int len = Integer.parseInt(lenStr.toString());
                decoded.add(str.substring(i + 1, i + 1 + len));
                i = i + 1 + len;
                lenStr = new StringBuilder();
            }
        }
        return decoded;
    }
}
