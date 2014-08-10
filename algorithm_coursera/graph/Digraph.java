package com.yiwei.graph;

public class Digraph {
	public void addEdge(int v, int w){
		adj[v].add(w);
		E++;
	}
	
	public Digraph reverse(){
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++){
			for (int w: G.adj(v)){
				R.addEdge(w, v);
			}
		}
	return R;
	}
	
	
}
