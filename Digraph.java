import java.util.ArrayList;
import java.util.List;

public class Digraph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Digraph(int V) {
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

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph reverseGraph = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                reverseGraph.addEdge(w, v);
            }
        }
        return reverseGraph;
    }

    public void print() {
        for (int v = 0; v < V; v++) {
            System.out.print(v + ": ");
            for (int w : adj[v]) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(1, 3);
        digraph.addEdge(2, 4);

        System.out.println("Original Digraph:");
        digraph.print();

        System.out.println("\nReversed Digraph:");
        Digraph reversed = digraph.reverse();
        reversed.print();
    }
}
