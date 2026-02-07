class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int cnt = 0;
        while(cnt<intervals.length&&newInterval[0]>intervals[cnt][1]) res.add(intervals[cnt++]);
        while(cnt<intervals.length&&newInterval[1]>=intervals[cnt][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[cnt][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[cnt][1]);
            cnt++;
        }
        res.add(newInterval);
        while(cnt<intervals.length) res.add(intervals[cnt++]);
        return res.toArray(new int[res.size()][]);

    }
}