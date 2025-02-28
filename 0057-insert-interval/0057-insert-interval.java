class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ll = new ArrayList<>();
        int i = 0;

        while(i<intervals.length&&intervals[i][1]<newInterval[0])
            ll.add(intervals[i++]);
        
        while(i<intervals.length&&intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ll.add(newInterval);
        while(i<intervals.length){
            ll.add(intervals[i++]);
        }

        return ll.toArray(new int[ll.size()][]);
    }
}