class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>((a,b)->Integer.compare(b, a));

        for(int n:nums) q.add(n);
        long score = 0l;
        for(int i = 0;i<k;i++){
            int tmp = q.poll();
            score+=tmp;
            q.add(Math.ceilDiv(tmp, 3));
        }
        return score;
    }
}