import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {
        List<Integer>[] graph;
        boolean[] visited;
        public int makeConnected(int n, int[][] connections) {
                if (connections.length < n - 1)  return -1;
                graph = buildGraph(n, connections);
                visited = new boolean[n];
                int numComponents = 0;

                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        dfs(i);
                        numComponents++;
                    }
                }

                return numComponents - 1;
        }

    private List<Integer>[] buildGraph(int n, int[][] connections) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++)  graph[i] = new ArrayList<>();
        for (int[] conn : connections) {
            int a = conn[0], b = conn[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }

    private void dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor])
                dfs(neighbor);
        }
    }
}