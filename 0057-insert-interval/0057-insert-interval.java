class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int cnt = 0, len = intervals.length;

        while(cnt<len && intervals[cnt][1]<newInterval[0]){
            result.add(intervals[cnt++]);
        }

        while(cnt<len && newInterval[1] >= intervals[cnt][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[cnt][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[cnt][1]);
            cnt++;
        }

        result.add(newInterval);

        while(cnt<len){
            result.add(intervals[cnt++]);
        }

        return result.toArray(new int[result.size()][]);
    }
}