class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[0]*a[0]+a[1]*a[1], b[0]*b[0]+b[1]*b[1]);
        });

        for(int[] p:points){
            q.add(p);
        }
        int[][] result = new int[k][2];

        for(int i=0;i<k;i++){
            result[i] = q.poll();
        }
        return result;
    }
}