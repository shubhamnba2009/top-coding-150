class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];

        for(char a:magazine.toCharArray()) map[a-'a']++;

        for(char a:ransomNote.toCharArray()){
            if(map[a-'a']==0) return false;
            map[a-'a']--;
        }
        return true;
    }
}