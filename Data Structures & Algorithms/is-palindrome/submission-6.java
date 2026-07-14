class Solution {
    public boolean isPalindrome(String s) {
        var arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && isNotAlphaNumeric(arr[left])) left++;
            while (left < right && isNotAlphaNumeric(arr[right])) right--;
            if (Character.toLowerCase(arr[left]) == Character.toLowerCase(arr[right])) {
                left++;
                right--;
            } else {
                return false;
            }

        }
        return true;

    }

    public boolean isNotAlphaNumeric(char c) {
        return !Character.isLetterOrDigit(c);
    }
}
