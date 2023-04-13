import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    List<Integer> ans;
    int[][] matrix;
    int[] arr;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ans = new ArrayList<>();
        matrix = graph;
        arr = new int[graph.length];
        for(int i=0; i<graph.length; i++)
            if(helper(i)) ans.add(i);
        return ans;
    }

    private boolean helper(int node){
        if(arr[node] != 0) return arr[node] == 1;
        arr[node] = 2;
        for(int e : matrix[node])
            if(!helper(e))  return false;
        arr[node] = 1;
        return true;
    }
}