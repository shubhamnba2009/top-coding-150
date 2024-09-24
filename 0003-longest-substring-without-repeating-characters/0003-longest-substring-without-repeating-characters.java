class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;
        while(right<s.length()){

            while(right<s.length()&&!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), right);
                right++;
            }
            res = Math.max(res, right-left);
            if(right<s.length())
            {
                left = Math.max(left,map.get(s.charAt(right))+1);
            map.remove(s.charAt(right));
            }
        }
        return res;
    }
}