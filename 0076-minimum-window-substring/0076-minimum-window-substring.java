class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, minLenght = Integer.MAX_VALUE, idx = -1, cnt = 0;
        int[] hash = new int[256];

        for(char a:t.toCharArray()) hash[a]++;
        while(right<s.length()){
            if(hash[s.charAt(right)]>0)   cnt++;
            hash[s.charAt(right)]--;
            while(cnt==t.length()){
                if(right-left+1<minLenght){
                    minLenght = right-left+1;
                    idx = left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)]>0)  cnt--;
                left++;
            }
            right++;
        }
        return idx==-1?"":s.substring(idx, idx+minLenght);
    }
}