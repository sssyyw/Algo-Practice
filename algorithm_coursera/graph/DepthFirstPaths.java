package com.yiwei.graph;

import java.util.*;

public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;  // for tracing paths
	private final int s;   // for tracing paths
	
	public DepthFirstPaths(Graph G, int s){
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G, s);
	}
	
	public void dfs(Graph G, int v){
		marked[v] = true;
		for (int w: G.adj(v)){
			if (!marked[w]){
				edgeTo[w] = v;             // record
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
		for (x = v; x != s; x = edgeTo[x]){      //*****************
			path.push(x);
		}
		path.push(x);
		return path;
	}
}
