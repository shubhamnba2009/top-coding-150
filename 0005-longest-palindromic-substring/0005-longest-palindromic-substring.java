class Solution {
    public String longestPalindrome(String s){ 
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (centered at a single character)
            int len1 = expandAroundCenter(s, i, i);
            // Even length palindromes (centered between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                // Update the start and end index of the longest palindrome found
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Expand around the center as long as the characters are equal
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}