class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] map = new int[256];
        for(char c:s.toCharArray()) map[c]++;
        for(char c:t.toCharArray()){
            if(map[c]==0)   return false;
            map[c]--;
        }
        return true;
    }
}