class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>((a,b)->Integer.compare(a, b)));
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            Integer tKey = map.get(key).floorKey(timestamp);
            if(tKey!=null){
                return map.get(key).get(tKey);
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */