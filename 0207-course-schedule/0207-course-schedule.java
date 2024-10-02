class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);

        for(int i = 0;i<numCourses;i++) adjList.add(i, new ArrayList<>());

        for(int[] pre: prerequisites){
            adjList.get(pre[1]).add(pre[0]);
        }

        boolean[] stack = new boolean[numCourses];
        boolean[] isVisited = new boolean[numCourses];

        for(int i = 0;i<numCourses;i++){
            if(dpHelper(i, adjList, stack, isVisited))
                return false;
        }
        return true;
    }

    public boolean dpHelper(int node, List<List<Integer>> adjList, boolean[] stack, boolean[] isVisited){
        if(stack[node])
            return true;
        if(isVisited[node])
            return false;
        isVisited[node] = true;
        stack[node] = true;
        for(int n: adjList.get(node)){
            if(dpHelper(n, adjList, stack, isVisited))
                return true;
        }
        stack[node] = false;
        return false;

    }
}