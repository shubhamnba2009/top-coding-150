class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);

        List<int[]> res = new ArrayList<>();

        for(int[] in:intervals){
            if(res.isEmpty()||res.getLast()[1]<in[0])   res.add(in);
            else{
                res.getLast()[1] = in[1]>res.getLast()[1]?in[1]:res.getLast()[1];
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}