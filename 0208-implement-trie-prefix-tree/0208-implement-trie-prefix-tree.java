class Node{
    boolean isCompleted;
    Node[] child;

    Node(){
        isCompleted = false;
        child = new Node[26];
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node tmp = root;

        for(char a: word.toCharArray()){
            if(tmp.child[a-'a'] == null){
                tmp.child[a-'a'] = new Node();
            }
            tmp = tmp.child[a-'a'];
        }
        tmp.isCompleted = true;
    }
    
    public boolean search(String word) {
        Node tmp = root;

        for(char a:word.toCharArray()){
            if(tmp.child[a-'a']==null){
                return false;
            }
            tmp = tmp.child[a-'a'];
        }

        return tmp.isCompleted?true:false;
    }
    
    public boolean startsWith(String prefix) {
        Node tmp = root;

        for(char a:prefix.toCharArray()){
            if(tmp.child[a-'a']==null){
                return false;
            }
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