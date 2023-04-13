import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSouceToTarget {
    int[][] matrix;
    List<List<Integer>> paths;
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            matrix= graph;
            paths = new ArrayList<>();
            List<Integer> currPath = new ArrayList<>();
            currPath.add(0);
            dfs(0, currPath);
            return paths;
    }

    public void dfs(int currNode, List<Integer> currPath){
            if(currNode == matrix.length-1){
                paths.add(new ArrayList<>(currPath));
                return;
            }
            for(int e : matrix[currNode]){
                currPath.add(e);
                dfs(e, currPath);
                currPath.remove(currPath.size()-1);
            }
    }
}
