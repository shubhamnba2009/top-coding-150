class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        for(int i = 0;i<s.length();i++){
            ans += expand(s, i, i);
            ans += expand(s, i, i+1);
        }

        return ans;
    }

    public int expand(String s, int left, int right){
        int ans = 0;

        while(left>=0&&right<s.length()){
            if(s.charAt(left)!=s.charAt(right))
                break;
            left--;
            right++;
            ans++;
        }

        return ans;
    }
}