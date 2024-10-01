class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        for(char a:s.toCharArray()){
            cnt.put(a, cnt.getOrDefault(a, 0)+1);
        }

        int res = 0, flg = 0;

        for(char a:cnt.keySet()){
            int val = cnt.get(a);
            if(val%2!=0) flg++;
            res+=val;
        }
        return res=res-(flg!=0?(flg-1):0);

    }
}