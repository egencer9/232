import java.util.LinkedList;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    private int[] edgeTo; // To store parent vertices

    public DepthFirstSearch(Graph G, int src) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, src);
    }

    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v; // Set the parent of w to be v
                dfs(G, w);
            }
        }
    }

    public int getCount() {
        return count;
    }

    public Iterable<Integer> pathTo(int v) {
        if (!marked[v]) {
            return null; // If v is not reachable from the source
        }
        LinkedList<Integer> path = new LinkedList<>();
        for (int x = v; x != 0; x = edgeTo[x]) {
            path.addFirst(x); // Add vertices in reverse order
        }
        path.addFirst(0); // Add the source vertex
        return path;
    }

    public static void main(String[] args) {
        // Create a sample graph
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        // Perform depth-first search from vertex 0
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);

        // Output the count of visited vertices
        System.out.println("Visited vertices count: " + dfs.getCount());

        // Example: Find a path from vertex 0 to vertex 4
        int destination = 4;
        Iterable<Integer> path = dfs.pathTo(destination);
        if (path != null) {
            System.out.print("Path from 0 to " + destination + ": ");
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        } else {
            System.out.println("There is no path from 0 to " + destination);
        }
    }
}
