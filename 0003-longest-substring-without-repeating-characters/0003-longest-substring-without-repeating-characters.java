class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0, end = 0, res = 0;

        while(end<s.length()){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(start, map.get(s.charAt(end))+1);
            }
            res=Math.max(res, end-start+1);
            map.put(s.charAt(end), end);
            end++;
        }

        return res;
    }
}