class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] map = new int[26];

        for(char ch: s.toCharArray())map[ch-'a']++;
        for(char ch: t.toCharArray()){
            if(map[ch-'a']==0) return false;
            map[ch-'a']--;
        }
        for(int i =0;i<26;i++)
        {
            if(map[i]!=0) return false;
        }
        return true;
    }
}