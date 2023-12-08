import java.util.*;

class KruskalAlgorithm {
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

    class Subset {
        int parent, rank;

        Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    private int V; 
    private List<Edge> edges;

    KruskalAlgorithm(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (subsets[xRoot].rank < subsets[yRoot].rank)
            subsets[xRoot].parent = yRoot;
        else if (subsets[xRoot].rank > subsets[yRoot].rank)
            subsets[yRoot].parent = xRoot;
        else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    void kruskalMST() {
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges);

        Subset[] subsets = new Subset[V];
        for (int i = 0; i < V; i++)
            subsets[i] = new Subset(i, 0);

        int edgeCount = 0;
        int i = 0;

        while (edgeCount < V - 1) {
            Edge nextEdge = edges.get(i);
            i++;

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                mst.add(nextEdge);
                union(subsets, x, y);
                edgeCount++;
            }
        }

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + ", Weight: " + edge.weight);
        }
    }

    public static void main(String[] args) {
        int V = 4; 
        KruskalAlgorithm graph = new KruskalAlgorithm(V);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        graph.kruskalMST();
    }
}
