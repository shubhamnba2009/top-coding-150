class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));

        for(int i = 0;i<points.length;i++){
            queue.add(points[i]);
        }

        int[][] result = new int[k][2];
        for(int i = 0;i<k;i++){
            int[] tmp = queue.poll();
            result[i][0] = tmp[0];
            result[i][1] = tmp[1];
            }
        return result;
        }
    }