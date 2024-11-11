class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())  return false;

        int[] ch = new int[256];

        for(char a:s.toCharArray()) ch[a]++;
        for(char a:t.toCharArray()){
            if(ch[a]==0) return false;
            else ch[a]--;
        }
        return true;
    }
}