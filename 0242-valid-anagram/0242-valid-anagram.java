class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] map = new int[26];

        for(char a:s.toCharArray()) map[a-'a']++;

        for(char a:t.toCharArray()){
            if(map[a-'a']==0) return false;
            map[a-'a']--;
        }
        return true;    
    }
}