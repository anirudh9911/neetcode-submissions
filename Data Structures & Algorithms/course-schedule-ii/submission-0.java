class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int count = 0;
        int[] out = new int[numCourses];
        Arrays.fill(out, -1);
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] arr : prerequisites) {
            int u = arr[0];
            int v = arr[1];
            adj[v].add(u);
            inDegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            out[count] = curr;
            count++;
            for (int nei : adj[curr]) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return count == numCourses? out : new int[]{};
    }
}
