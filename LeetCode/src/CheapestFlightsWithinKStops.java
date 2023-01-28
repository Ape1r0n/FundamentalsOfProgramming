public class CheapestFlightsWithinkKStops{
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        	int[] dist = new int[n];
       		Arrays.fill(dist, Integer.MAX_VALUE);
        	dist[src] = 0;
        	for (int i = 0; i <= K; i++) {
            		int[] temp = Arrays.copyOf(dist, n);
            		for (int[] flight : flights) {
                		int u = flight[0], v = flight[1], w = flight[2];
               			if(dist[u] != Integer.MAX_VALUE) temp[v] = Math.min(temp[v], dist[u] + w);
            		}
            		dist = temp;
        	}
        	return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    	}
}
