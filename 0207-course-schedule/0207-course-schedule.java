class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            adjList.add(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adjList.get(pre[1]).add(pre[0]);
        }

        boolean[] stack = new boolean[numCourses];
        boolean[] isVisited = new boolean[numCourses];

        for(int i = 0;i<numCourses;i++){
            if(helper(adjList, stack, isVisited, i))
                return false;
        }
        return true;
    }

    private boolean helper(List<List<Integer>> adjList, boolean[] stack, boolean[] isVisited, int idx){
        if(stack[idx])  return true;
        if(isVisited[idx]) return false;

        stack[idx] = true;
        isVisited[idx] = true;

        for(int n : adjList.get(idx)){
            if(helper(adjList, stack, isVisited, n))
                return true;
        }
        stack[idx] = false;
        return false;
    }
}