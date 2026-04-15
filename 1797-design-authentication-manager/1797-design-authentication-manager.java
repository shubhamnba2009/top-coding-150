class AuthenticationManager {
    class Store{
        String key;
        int time;
        public Store(String key, int time){
            this.key = key;
            this.time = time;
        }
    }
    ArrayList<Store> order;
    int limit;
    HashMap<String, Integer> map;
    public AuthenticationManager(int timeToLive) {
        order = new ArrayList<>();
        map = new HashMap<>();
        limit = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime+limit);
        int ind = binaryInd(currentTime+limit);
        order.add(ind, new Store(tokenId, currentTime+limit));
    }

    public void renew(String tokenId, int currentTime) {
        if(!map.containsKey(tokenId) || map.get(tokenId) <= currentTime) return;
        int ind = binaryFnd(tokenId, map.get(tokenId));
        order.remove(ind);
        ind = binaryInd(currentTime+limit);
        order.add(ind, new Store(tokenId, currentTime+limit));
        map.put(tokenId, currentTime+limit);
    }

    public int countUnexpiredTokens(int currentTime) {
        int ind = binaryInd(currentTime);
        return order.size()-ind;
    }

    public int binaryInd(int tar){
        int st = 0;
        int ed = order.size()-1;
        while(st <= ed){
            int mid = st + (ed-st)/2;
            if(order.get(mid).time <= tar){
                st = mid+1;
            }
            else ed = mid-1;
        }

        return st;
    }

    public int binaryFnd(String tknId, int tar){
        int st = 0;
        int ed = order.size()-1;
        while(st <= ed){
            int mid = st + (ed-st)/2;
            if(order.get(mid).time == tar){
                st = mid;
                break;
            }
            else if(order.get(mid).time < tar) st = mid+1;
            else ed = mid-1;
        }

        int ind = st;
        while(ind >= 0 && order.get(ind).time == tar){
            if(order.get(ind).key.equals(tknId)){
                return ind;
            }
            ind--;
        }
        ind = st;
        while(ind < order.size() && order.get(ind).time == tar){
            if(order.get(ind).key.equals(tknId)){
                return ind;
            }
            ind++;
        }

        return ind;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */