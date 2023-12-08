import java.util.Scanner;
import java.util.ArrayList;

class Solution {
 boolean cycle = false;

    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edgelist : prerequisites) {
            int u = edgelist[1];
            int v = edgelist[0];

            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[n];
        boolean[] currentPath = new boolean[n];

        for (int i = 0; i < n; i++) {
            dfs(i, graph, visited, currentPath);
        }

        return !cycle;
    }

    public void dfs(int v, ArrayList<ArrayList<Integer>> g, boolean[] vis, boolean[] cur) {
        if (cur[v]) {
            cycle = true;
        }

        if (vis[v] || cycle) {
            return;
        }

        vis[v] = true;
        cur[v] = true;

        for (int adj : g.get(v)) {
            dfs(adj, g, vis, cur);
        }

        cur[v] = false;
    }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numCourses = sc.nextInt();
    int n = sc.nextInt();
    int arr[][] = new int[n][2];
    for(int i=0;i<n ;i++){
        for(int j=0; j<2; j++) {
            arr[i][j] = sc.nextInt();
        }
    }
    Solution solution = new Solution();
    System.out.println(solution.canFinish(numCourses, arr));
}
}

