class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];

        int res = Integer.MAX_VALUE;

        for(char a:t.toCharArray()){
            map[a]++;
        }

        int left = 0, right = 0, len = t.length(), cnt = 0, idx = -1;

        while(right<s.length()){
            if(map[s.charAt(right)]>0) cnt++;
            map[s.charAt(right)]--;

            while(cnt==len){
                if(res>right-left+1){
                    idx = left;
                    res = right-left+1;
                }

                map[s.charAt(left)]++;
                if(map[s.charAt(left)]>0) cnt--;
                left++;
            }
            right++;
        }

        return idx==-1?"":s.substring(idx, idx+res);
    }
}