import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private List<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        List<Edge> edges = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    edges.add(e);
                }
            }
        }
        return edges;
    }

    public void print() {
        for (int v = 0; v < V; v++) {
            System.out.print(v + ": ");
            for (Edge e : adj[v]) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(5);
        graph.addEdge(new Edge(0, 1, 0.5));
        graph.addEdge(new Edge(0, 2, 0.8));
        graph.addEdge(new Edge(1, 3, 0.6));
        graph.addEdge(new Edge(2, 4, 0.3));

        System.out.println("Edge-weighted graph:");
        graph.print();
    }
}
