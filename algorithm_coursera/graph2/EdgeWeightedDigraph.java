package com.yiwei.graph2;

import com.yiwei.graph.*;

public class EdgeWeightedDigraph {
	private final int V;
	private int E;
	private Bag<DirectedEdge>[] adj;
	
	public EdgeWeightedDigraph(int V) {
		if (V < 0) throw new IllegalArgumentException("must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for (int v = 0; v < V; v++){
			adj[v] = new Bag<DirectedEdge>();
		}
	}
	
	// random
	public EdgeWeightedDigraph(int V, int E) {
		this(V);
		if (E < 0) throw new IllegalArgumentException("must be nonnegative");
		for (int i = 0; i < E; i++){
			int v = (int) (Math.random() * V);
			int w = (int) (Math.random() * V);
			double weight = Math.round(100 * Math.random())/100.0;
			DirectedEdge e = new DirectedEdge(v, w, weight);
			addEdge(e);
		}
	}
	
	public EdgeWeightedDigraph(EdgeWeightedDigraph G){
		this(G.V());
		this.E = G.E();
	}
	
	public int V(){
		return V;
	}
	
	public int E() {return E;}
	
	public void addEdge(DirectedEdge e){
		int v = e.from();
		adj[v].add(e);
		E++;
	}
		
	public Iterable<DirectedEdge> adj(int v){
		if ( v < 0 || v >= V) throw new IndexOutOfBoundsException();
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> list = new Bag<DirectedEdge>();
		for (int v = 0; v < V; v++){
			for (DirectedEdge e: adj(v)){
				list.add(e);
			}
		}
		return list;
	}
	
	public int outdegree (int v){
		if ( v < 0 || v >= V) throw new IndexOutOfBoundsException();
		return adj[v].size();
	}
}

