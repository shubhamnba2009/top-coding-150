class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        for(int[] in: intervals){
            if(res.isEmpty())   res.add(in);

            else if(res.getLast()[1]<in[0] || in[0]>res.getLast()[1])  res.add(in);
            else res.getLast()[1] = Math.max(in[1], res.getLast()[1]);
        }

        return res.toArray(new int[res.size()][]);
    }
}