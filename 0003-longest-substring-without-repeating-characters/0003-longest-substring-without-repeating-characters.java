class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxL = 0;
        int start = 0, end=0;
        while(end<s.length()){
            char endc = s.charAt(end);
            map.putIfAbsent(endc, 0);
            map.put(endc, map.get(endc)+1);
            while(map.get(endc)>1){
                char startc = s.charAt(start);
                map.put(startc, map.get(startc)-1);
                start++;
            }

            maxL = Math.max(maxL, (end-start+1));
            end++;
        }
        return maxL;
    }
}