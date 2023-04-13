import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInfromAllEmployees {
    Map<Integer, List<Integer>> graph;
    int[] arr;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        graph = buildGraph(n, manager);
        arr = informTime;
        return dfs(headID);
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[] manager) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) graph.put(i, new ArrayList<>());
            int m = manager[i];
            if (m != -1) {
                if (!graph.containsKey(m))
                    graph.put(m, new ArrayList<>());
                graph.get(m).add(i);
            }
        }
        return graph;
    }

    private int dfs(int node) {
        int maxTime = 0;
        if (graph.containsKey(node)) {
            for(int i : graph.get(node))
                maxTime = Math.max(maxTime, dfs(i));
        }
        return maxTime + arr[node];
    }
}