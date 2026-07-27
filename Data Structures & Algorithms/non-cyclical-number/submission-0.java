class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> covered = new HashSet<>();
        while(!covered.contains(n)){
            covered.add(n);
            n = sumOfNumberSquare(n);
            if(n == 1) return  true;
        }
        return false;
    }

    private int sumOfNumberSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            digit = digit * digit;
            sum = sum + digit;
            n = n / 10;
        }
        return sum;
    }
}
