class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n:nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        int res = -1;

        for(int key : map.keySet()){
            if(map.get(key)==1) res = Math.max(res, key);
        }
        return res;
    }
}