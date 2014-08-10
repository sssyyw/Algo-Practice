package com.yiwei.graph2;

public class KruskalMST {
	private double weight;
	private Queue<Edge> mst = new Queue<Edge>();
	
	public KruskalMST(EdgeWeightedGraph G){
		MinPQ pq = new MinPQ<Edge>();
		for (Edge e: G.edges()){
			pq.insert(e);
		}
		
		// run greedy algorighm
		UF uf = new UF(G.V());
		while (!pq.isEmpty() && mst.size() < G.V() -1){
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (!uf.connected(v, w)){
				uf.union(v,w);
				mst.enqueue(e);
				weight += e.weight();
			}
		}
	}
}
