class TrieNode{
    TrieNode[] child;
    boolean isWord;

    TrieNode(){
        child = new TrieNode[26];
        isWord = false;
    }
}
class Solution {
    TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) {
        // Insertion
        root = new TrieNode();
        for(String str : wordDict){
            TrieNode tmp = root;
            char[] ch = str.toCharArray();
            for(char a:ch){
                if(tmp.child[a-'a']==null){
                    tmp.child[a-'a'] = new TrieNode();
                }
                tmp = tmp.child[a-'a'];
            }
            tmp.isWord = true;
        }
        boolean[] dp = new boolean[s.length()];
        // Search
        for(int i = 0;i<s.length();i++) {
            if(i==0 || dp[i-1]){
                TrieNode tmp = root;
                for(int j = i;j<s.length();j++){
                    if(tmp.child[s.charAt(j)-'a']==null){
                        break;
                    }
                    
                    tmp = tmp.child[s.charAt(j)-'a'];
                    if(tmp.isWord) dp[j] = true;
                }
            }
        }
        return dp[s.length()-1];
    }
}