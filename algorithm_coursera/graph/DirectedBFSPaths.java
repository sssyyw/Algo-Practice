package com.yiwei.graph;

public class DirectedBFSPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private static final int INF = Integer.MAX_VALUE;
	
	public DirectedBFSPaths(DiGraph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INF;
		bfs(G, s);
	}
	
	private void bfs(DiGraph G, int s){
		marked[s] = true;
		distTo[s] = 0;
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		
		while(!q.isEmpty()){
			int v = q.dequeue();
			
			for (int w: G.adj(v)){
				if (!marked[w]){
					marked[w] = true;
					distTo[w] = dist[v] + 1;
				    edgeTo[w] = v;
				    q.enqueue(w);
				}
			}
		}
		
	}
	
}
