class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, len = s.length(), res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right<len){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right))+1);
            }
            res = Math.max(res, right-left +1);
            map.put(s.charAt(right), right);
            right++;
        }
        return res;
    }
}