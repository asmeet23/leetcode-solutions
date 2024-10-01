class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];
        
        // Calculate the remainder of each number in arr and increase the count in the remainder array
        for (int num : arr) {
            int remainder = (num % k + k) % k;  // To handle negative numbers
            remainderCount[remainder]++;
        }
        
        // Check if we can form pairs
        for (int i = 1; i < k; i++) {
            // If there are numbers with remainder i, there should be an equal number of numbers with remainder k-i
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }
        
        // Special case: numbers with remainder 0 must form pairs among themselves
        if (remainderCount[0] % 2 != 0) {
            return false;
        }
        
        return true;
    }
}
