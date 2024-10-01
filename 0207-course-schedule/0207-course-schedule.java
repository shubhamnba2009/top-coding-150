class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);

        for(int i  = 0;i<numCourses;i++){
            adjList.add(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adjList.get(pre[1]).add(pre[0]);
        }

        boolean[] stack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for(int i = 0;i<numCourses;i++){
            if(dfs(adjList, stack, visited, i))
                return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adjList, boolean[] stack, boolean[] visited, int n){
        if(stack[n])    return true;
        if(visited[n])  return false;

        stack[n] = true; visited[n] = true;

        for(int node: adjList.get(n)){
            if(dfs(adjList, stack, visited, node)) return true;
        }
        stack[n] = false;
        return false;
    }
}