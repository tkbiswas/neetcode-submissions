class Solution {
    public boolean isPalindrome(String s) {
        List<Character> collect = s.toLowerCase().chars().filter(Character::isLetterOrDigit).mapToObj(c -> (char) c).collect(Collectors.toList());
        int left = 0;
        int right = collect.size() - 1;
        while (left < right) {
            if (collect.get(left) == collect.get(right)) {
                left++;
                right--;
            } else {
                return false;
            }

        }
        return true;

    }
}
