import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        Stack<Integer> keys = new Stack<>();
        keys.add(0);

        while(!keys.isEmpty()){
            int currKey = keys.pop();
            for(int k : rooms.get(currKey)){
                if(!visited[k]){
                    visited[k] = true;
                    keys.add(k);
                }
            }
        }

        for(boolean e : visited)
            if(!e) return false;
        return true;
    }
}