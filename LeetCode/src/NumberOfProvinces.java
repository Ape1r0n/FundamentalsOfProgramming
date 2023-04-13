public class NumberOfProvinces {
        int[][] graph;
        int[] visited;
        int ans = 0;

        public int findCircleNum(int[][] isConnected) {
                graph = isConnected;
                visited = new int[isConnected.length];
                for(int i=0; i<isConnected.length; i++){
                        if(visited[i] == 0){
                                helper(i);
                                ans++;
                        }
                }
                return ans;
        }

        public void helper(int currCity){
                for(int i=0; i<graph.length; i++){
                        if(graph[currCity][i] == 1 && visited[i] == 0){
                                visited[i] = 1;
                                helper(i);
                        }
                }
        }
}