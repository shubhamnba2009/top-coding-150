class TrieNode{
    boolean isCompleted;
    TrieNode[] child;

    TrieNode(){
        isCompleted = false;
        child = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode tmp = root;

        for(char a: word.toCharArray()){
            if(tmp.child[a-'a']==null){
                tmp.child[a-'a'] = new TrieNode();
            }
            tmp = tmp.child[a-'a'];
        }
        tmp.isCompleted = true;
    }
    
    public boolean search(String word) {
        TrieNode tmp = root;

        for(char a:word.toCharArray()){
            if(tmp.child[a-'a']==null)
                return false;
            tmp = tmp.child[a-'a'];
        }
        if(tmp.isCompleted)
            return true;

        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;

        for(char a:prefix.toCharArray()){
            if(tmp.child[a-'a']==null)
                return false;
            tmp = tmp.child[a-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */