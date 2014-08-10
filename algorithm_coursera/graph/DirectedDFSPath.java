package com.yiwei.graph;

import java.util.Stack;

public class DirectedDFSPath {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public DirectedDFSPath(DiGraph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	private void dfs(DiGraph G, int v){
		marked[v] = true;
		for (int w: G.adj(v)){
			if (!marked[w]){
				//marked[w] = true; no need because of rec
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x = v; x != s; x = edgeTo[x]){
			path.push(x);
		}
		path.push(x);
		return path;
	}
}
