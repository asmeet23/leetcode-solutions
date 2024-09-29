class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1; // Base case: x^0 = 1
        }
        if (x == 0) {
            return 0; // x^n = 0 for any n if x is 0
        }

        // Handle negative powers
        long N = n; // Use long to handle edge case when n is Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        // Recursively compute the power using divide and conquer
        double half = myPow(x, (int)(N / 2));
        if (N % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
