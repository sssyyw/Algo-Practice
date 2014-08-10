package com.yiwei.graph;

import java.util.Stack;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	/***depth first search from v***/
	private void dfs (Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w: G.adj(v)){
			if (!marked[w])
			    dfs(G, w);
		}
	}
	
	private void dfs_stack (Graph G, int v){
		marked[v] = true;
		Stack<Integer> sk = new Stack<Integer>();
		sk.push(v);
		
		while(!sk.isEmpty()){
			int n = sk.pop();
			for (int w: G.adj(n)){
				if (!marked[w]){
					marked[w] = true;
					sk.push(w);
				}
			}
		}
		
		
		
	}
	
	
	public boolean marked(int v){
		return marked[v];
	}
	
	public int count(){
		return count;
	}

}
