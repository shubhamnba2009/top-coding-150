class Solution {
    public long[] maximumCoins(int[] h, int[] m, int[] coins) {
        long[] res = new long[h.length];

        TreeMap<Integer, Long> mc = new TreeMap<>();
        for(int i = 0;i<m.length;i++){
            if(mc.containsKey(m[i])){
                mc.put(m[i], mc.get(m[i])+(long)coins[i]);
            } else {
             mc.put(m[i], (long)coins[i]);
            }
        }
        long tmp = 0;
        for(int k:mc.keySet()){
            tmp += mc.get(k);
            mc.put(k, tmp);
        }
        for(int i = 0;i<h.length;i++){
            Integer key = mc.floorKey(h[i]);
            res[i] =  key!=null?mc.get(key):0;
        }
        return res;
    }
}