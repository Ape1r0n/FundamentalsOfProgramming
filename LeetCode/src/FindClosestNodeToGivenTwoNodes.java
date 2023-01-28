import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindClosestNodeToGivenTwoNodes {
    public int getCommonNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        Arrays.fill(dist1, -1);
        int[] dist2 = new int[n];
        Arrays.fill(dist2, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node1);
        dist1[node1] = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            if (edges[current] != -1 && dist1[edges[current]] == -1) {
                queue.add(edges[current]);
                dist1[edges[current]] = dist1[current] + 1;
            }
        }
        queue = new LinkedList<>();
        queue.add(node2);
        dist2[node2] = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            if (edges[current] != -1 && dist2[edges[current]] == -1) {
                queue.add(edges[current]);
                dist2[edges[current]] = dist2[current] + 1;
            }
        }
        int minMaxDist = Integer.MAX_VALUE;
        int minMaxDistNode = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    minMaxDistNode = i;
                }
            }
        }
        return minMaxDistNode;
    }
}