package com.yiwei.graph;

import java.util.*;

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo; // number of edges on shortest s-v path
	private static final int INFINITY = Integer.MAX_VALUE;
	
	public BreadthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
		//this.s = s; 
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s){
		Queue<Integer> q = new Queue<Integer>();	
		distTo[v] = 0;
		marked[s] = true;
		q.enqueue(s);
		
		while(!q.isEmpty()){
			int v = q.dequeue();
			for (int w: G.adj(v)){
				if (!marked[w]){
					marked[w] = true;
					distTo[w] = distTo[v] + 1;
					edgeTo[w] = v;
					q.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public int distTo(int v){
		return distTo[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x = v; distTo[x] != 0; x = edgeTo[x]){  //distTo[x] != 0
			path.push(x);
		}
		path.push(x);
		return path;
	}
	
}
