package com.yiwei.graph;

public class CC {
	private boolean[] marked;
	private int[] id;
	private int[] size;
	private int count;
	
	public CC(Graph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		for (int v = 0; v < G.V(); v++){
			if (!marked[v]){
				dfs(G, v);
				count++;
			}
		}
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		id[v] = count;
		size[count]++;
		for (int w: G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
	}
}
