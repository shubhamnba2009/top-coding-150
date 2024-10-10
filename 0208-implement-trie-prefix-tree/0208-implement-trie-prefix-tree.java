class TrieNode{
    boolean isCompleted;
    TrieNode[] childrens;

    TrieNode(){
        isCompleted = false;
        childrens = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode tmp = root;
        for(char a:word.toCharArray()){
            if(tmp.childrens[a-'a'] == null){
            tmp.childrens[a-'a'] = new TrieNode();
            }
            tmp = tmp.childrens[a-'a'];
        }
        tmp.isCompleted=true;
    }
    
    public boolean search(String word) {
        TrieNode tmp = root;
        for(char a:word.toCharArray()){
            if(tmp.childrens[a-'a']==null) return false;
            tmp = tmp.childrens[a-'a'];
        }
        return tmp.isCompleted?true:false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(char a:prefix.toCharArray()){
            if(tmp.childrens[a-'a']==null) return false;
            tmp = tmp.childrens[a-'a'];
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