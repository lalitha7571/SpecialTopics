import java.util.*;

class CommutableIslands {

    class Edge implements Comparable<Edge> {
        int src, dest, cost;

        Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }

    private int[] parent;

    int find(int island) {
        if (parent[island] != island)
            parent[island] = find(parent[island]);
        return parent[island];
    }

    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        parent[xRoot] = yRoot;
    }

    public int solve(int A, int[][] B) {
        List<Edge> edges = new ArrayList<>();
        for (int[] bridge : B) {
            edges.add(new Edge(bridge[0], bridge[1], bridge[2]));
        }

        Collections.sort(edges);

        parent = new int[A + 1];
        for (int i = 0; i <= A; i++)
            parent[i] = i;

        int totalCost = 0;
        int edgesAdded = 0;

        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;
            int cost = edge.cost;

            int srcParent = find(src);
            int destParent = find(dest);

            if (srcParent != destParent) {
                union(src, dest);
                totalCost += cost;
                edgesAdded++;
                if (edgesAdded == A - 1)
                    break;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int A1 = 4;
        int[][] B1 = {
            {1, 2, 1},
            {2, 3, 4},
            {1, 4, 3},
            {4, 3, 2},
            {1, 3, 10}
        };

        CommutableIslands solver = new CommutableIslands();
        System.out.println(solver.solve(A1, B1));

        int A2 = 4;
        int[][] B2 = {
            {1, 2, 1},
            {2, 3, 2},
            {3, 4, 4},
            {1, 4, 3}
        };

        System.out.println(solver.solve(A2, B2));
    }
}
