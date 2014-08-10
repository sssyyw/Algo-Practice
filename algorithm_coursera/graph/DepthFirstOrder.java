package com.yiwei.graph;

public class DepthFirstOrder {
	private boolean[] marked;
	private int[] pre;
	private int[] post;
	private int preCounter;
	private int postCounter;
	private Queue<Integer> preorder;
	private Queue<Integer> postorder;
	
	private void dfs(Digraph G, int v){
		marked[v] = true;
		pre[v] = preCounter++;
		preorder.enqueue(v);
		for (int w: G.adj(v)){
			if (!marked[w])
				marked[w] = true;
		}
		postorder.enqueue(v);
		post[v] = postCounter++;
	}
}
