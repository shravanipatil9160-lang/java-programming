import java.util.*;

public class ShortestPathUnweightedGraph {

    public static int shortestPath(int V, List<int[]> edges, int start, int end) {
    
        if (start == end) return 0;

    
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        
        boolean[] visited = new boolean[V];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    if (neighbor == end) {
                        return depth + 1;
                    }
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, depth + 1});
                }
            }
        }

    
        return -1;
    }

    
    public static void main(String[] args) {
        List<int[]> edges1 = Arrays.asList(
                new int[]{0, 1}, new int[]{0, 2},
                new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 4});
        System.out.println(shortestPath(5, edges1, 0, 4)); 

        List<int[]> edges2 = Arrays.asList(
                new int[]{0, 1}, new int[]{1, 2});
        System.out.println(shortestPath(3, edges2, 0, 2)); 

        List<int[]> edges3 = Arrays.asList(
                new int[]{0, 1}, new int[]{1, 2});
        System.out.println(shortestPath(4, edges3, 2, 3)); 

        // Edge case
        List<int[]> edges4 = new ArrayList<>();
        System.out.println(shortestPath(1, edges4, 0, 0)); 
    }
}
