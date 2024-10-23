class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mag = new int[26];
        for(char a:magazine.toCharArray()) mag[a-'a']++;
        for(char a:ransomNote.toCharArray()){
            --mag[a-'a'];
            if(mag[a-'a']<0) return false;
        }
        return true;
    }
}