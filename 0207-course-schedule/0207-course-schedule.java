class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);

        for(int i = 0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] prerequisite:prerequisites){
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] stack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for(int n = 0;n<numCourses;n++){
            if(dfs(n, adjList, stack, visited)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int n, List<List<Integer>> adjList, boolean[] stack, boolean[] visited) {
        if(stack[n])
            return true;
        if(visited[n])
            return false;

        visited[n] = true;
        stack[n] = true;

        for(int i:adjList.get(n)){
            if(dfs(i, adjList, stack, visited))
                return true;
        }

        stack[n] = false;
        return false;
    }
}