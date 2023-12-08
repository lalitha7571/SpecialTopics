import java.util.*;

class PrimsAlgorithm {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    private int V;
    private List<List<Edge>> adjList;

    PrimsAlgorithm(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        adjList.get(src).add(edge);
        Edge reverseEdge = new Edge(dest, src, weight);
        adjList.get(dest).add(reverseEdge);
    }

    void primMST() {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        int[] key = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(-1, 0, 0));

        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentVertex = currentEdge.dest;

            if (visited[currentVertex])
                continue;

            visited[currentVertex] = true;
            parent[currentVertex] = currentEdge.src;

            for (Edge edge : adjList.get(currentVertex)) {
                if (!visited[edge.dest] && edge.weight < key[edge.dest]) {
                    pq.offer(edge);
                    key[edge.dest] = edge.weight;
                }
            }
        }

        System.out.println("Minimum Spanning Tree:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + ", Weight: " + key[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        PrimsAlgorithm graph = new PrimsAlgorithm(V);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}
