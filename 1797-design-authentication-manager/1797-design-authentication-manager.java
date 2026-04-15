class AuthenticationManager {

    private int timeToLive;
    private final HashMap<String, Node> tokenToTtl;
    private Node dummyHead;
    private Node dummyTail;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokenToTtl = new HashMap<>();
        dummyHead = new Node("InvalidHeaderToken", -1);
        dummyTail = new Node("InvalidTailToken", -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public void generate(String tokenId, int currentTime) {
        Node node = new Node(tokenId, currentTime + timeToLive);
        tokenToTtl.put(tokenId, node);
        add(node);
    }

    private void add(Node node){
        Node next = dummyHead.next;
        dummyHead.next = node;
        node.next = next;
        node.prev = dummyHead;
        next.prev = node;
    }
    
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void renew(String tokenId, int currentTime) {
        Node node = tokenToTtl.get(tokenId);
        if (node == null) return;
        remove(node);
        if (node.expiryTime <= currentTime){
            tokenToTtl.remove(tokenId); //remove as expired
            return; //don't renew as expired
        }
        node = new Node(tokenId, currentTime + timeToLive);
        tokenToTtl.put(tokenId, node);
        add(node);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        Node curr = dummyTail.prev;
        while (curr != dummyHead && curr.expiryTime <= currentTime){
            tokenToTtl.remove(curr.tokenId); //remove as expired
            remove(curr);
            curr = curr.prev;
        }
        return tokenToTtl.size();
    }
}

class Node{
    String tokenId;
    int expiryTime;
    Node prev;
    Node next;


    Node(String tokenId, int expiryTime){
        this.tokenId = tokenId;
        this.expiryTime = expiryTime;
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */