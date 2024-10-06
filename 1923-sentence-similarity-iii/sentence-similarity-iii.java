class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split both sentences into words by space
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        
        // Initialize pointers for both sentences
        int i = 0, j = 0;
        
        // Compare the words from the beginning of both sentences
        while (i < s1.length && j < s2.length) {
            // If words at position i and j don't match, stop the loop
            if (!s1[i].equals(s2[j])) break;
            i++;
            j++;
        }
        
        // If we've reached the end of either sentence, they are similar
        if (i == s1.length || j == s2.length) return true;
        
        // Initialize pointers for comparing from the end of both sentences
        int len1 = s1.length - 1, len2 = s2.length - 1;
        
        // Compare the words from the end of both sentences
        while (len1 >= i && len2 >= j) {
            // If words at len1 and len2 don't match, sentences aren't similar
            if (!s1[len1].equals(s2[len2])) return false;
            len1--;
            len2--;
        }
        
        // Return true if one sentence is a prefix or suffix of the other
        return len1 < i || len2 < j;
    }
}
