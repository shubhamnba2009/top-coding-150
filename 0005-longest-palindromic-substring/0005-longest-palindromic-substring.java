class Solution {
    public String longestPalindrome(String s) {
        if(s==null ||s.length()<1) return "";

        int start = 0, end = 0, maxLen = 0;

        for(int i = 0;i<s.length();i++){
            int[] f = expand(s, i, i);
            int[] f1 = expand(s, i, i+1);

            if(f[1]-f[0]>f1[1]-f1[0]){
                if(f[1]-f[0]>end-start){
                    start = f[0];end = f[1];
                }
            } else {
                if(f1[1]-f1[0]>end-start){
                start = f1[0]; end = f1[1];
                }
            }
        }

        return s.substring(start, end+1);
    }

    private int[] expand(String s, int left, int right){
        while(left>=0&&right<s.length()&&s.charAt(left) == s.charAt(right)){
            left--;right++;
        }
        return new int[]{left+1, right-1};
    }
}