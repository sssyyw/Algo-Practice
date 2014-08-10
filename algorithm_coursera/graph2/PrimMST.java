package com.yiwei.graph2;

import com.yiwei.sort.IndexMinPQ;

public class PrimMST {

	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;
	
	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		for (int v = 0; v < G.V(); v++)
			if(!marked[v]) prim(G, v);
	}
	
	private void prim(EdgeWeightedGraph G, int s){
		distTo[s] = 0.0;
		pq.insert(s, distTo[s]);                   //***index is vertice, key is min edge to w
		while (!pq.isEmpty()){
			int v = pq.delMin();                   //***
			scan(G, v);
		}
	}
	
	private void scan(EdgeWeightedGraph G, int v){
		marked[v] = true;                         // no visited node
		for (Edge e: G.adj(v)){
			int w = e.other(v);
			if (marked[w]) continue;
			if (e.weight() < distTo[w]){
				distTo[w] = e.weight();
				edgeTo[w] = e;
				if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);  // update
				else                pq.insert(w, distTo[w]);
			}
		}
	}
}
