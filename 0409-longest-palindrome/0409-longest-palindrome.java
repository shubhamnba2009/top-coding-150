class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[58];

        for(char a:s.toCharArray()){
            freq[a-'A']++;
        }
        int res = 0;
        for(int i:freq){
            res += (i%2==0)?i:i-1;
        }
        return res==s.length()?res:res+1;
    }
}