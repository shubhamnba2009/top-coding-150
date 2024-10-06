class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);

        for(int i = 0;i<numCourses;i++){
            adjList.add(i, new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            adjList.get(pre[1]).add(pre[0]);
        }

        boolean[] stack = new boolean[numCourses];
        boolean[] isVisited = new boolean[numCourses];

        for(int i = 0;i<numCourses;i++){
            if(checkHelper(i, adjList, stack, isVisited)){
                return false;
            }
        }
        return true;
    }

    public boolean checkHelper(int n, List<List<Integer>> adjList, boolean[] stack, boolean[] isVisited){
        if(stack[n])
            return true;
        if(isVisited[n])
            return false;

        isVisited[n] = true;
        stack[n] = true;
        for(int i : adjList.get(n)){
            if(checkHelper(i, adjList, stack, isVisited)) return true;
        }
        stack[n] = false;
        return false;
    }
}