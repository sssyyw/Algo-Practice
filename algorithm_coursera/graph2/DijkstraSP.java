package com.yiwei.graph2;

import com.yiwei.sort.*;

public class DijkstraSP {
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s){
		//////// init
		for (DirectedEdge e: G.edges()){
			if(e.weight() < 0)
				throw new IllegalArgumentException("edge " + e + " has negative weight");
		}
		
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		for (int v = 0; v < G.V(); v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		
		////////////////////////////////////////////////////////
		pq = new IndexMinPQ<Double>(G.V());
		pq.insert(s, distTo[s]);
		
		while(!pq.isEmpty()){
			int v = pq.delMin();			
			for (DirectedEdge e: G.adj(v)){
				relax(e);
			}
		}
	}
	//////////////////////////////Note: no marked for "relax"!!!//////////////////////
	private void relax(DirectedEdge e){
		int v = e.from();
		int w = e.to();
		if (distTo[w] > distTo[v] + e.weight()){   // relaxation different from PrimMST
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
			else                pq.insert(w, distTo[w]);
		}
	}
}
