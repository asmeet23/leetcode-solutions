class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        int even = 5;  // There are 5 even digits: 0, 2, 4, 6, 8
        int odd = 4;   // There are 4 prime digits: 2, 3, 5, 7

        // Use modular exponentiation to calculate the powers
        long evenCount = power(even, (n + 1) / 2);  // Number of even positions (ceil(n / 2))
        long oddCount = power(odd, n / 2);          // Number of odd positions (floor(n / 2))

        // Return the total count modulo MOD
        return (int) (evenCount * oddCount % MOD);
    }

    // Helper function for modular exponentiation (x^y % MOD)
    private long power(int base, long exp) {
        long result = 1;
        long x = base;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = result * x % MOD;
            }
            x = x * x % MOD;
            exp /= 2;
        }

        return result;
    }
}
