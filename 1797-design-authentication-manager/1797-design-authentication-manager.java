class AuthenticationManager {
    private int ttl;
    private Map<String, Integer> map;
    private Deque<Pair> queue;

    class Pair {
        String token;
        int expire;
        Pair(String t, int e) {
            token = t;
            expire = e;
        }
    }

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        this.map = new HashMap<>();
        this.queue = new ArrayDeque<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        int expire = currentTime + ttl;
        map.put(tokenId, expire);
        queue.offerLast(new Pair(tokenId, expire));
    }
    
    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId)) return;
        
        int expire = map.get(tokenId);
        if (expire <= currentTime) return;

        int newExpire = currentTime + ttl;
        map.put(tokenId, newExpire);
        queue.offerLast(new Pair(tokenId, newExpire));
    }
    
    public int countUnexpiredTokens(int currentTime) {
        // 🔥 lazy delete
        while (!queue.isEmpty()) {
            Pair p = queue.peekFirst();

            // 如果这个 pair 是过期的
            if (p.expire <= currentTime) {
                queue.pollFirst();

                // ⚠️ 关键：只删除“当前有效版本”
                if (map.getOrDefault(p.token, -1) == p.expire) {
                    map.remove(p.token);
                }
            } else {
                break;
            }
        }

        return map.size();
    }
}
/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */