package com.yiwei.graph2;

public class DirectedEdge {
	private final int v;
	private final int w;
	private final double weight;
	
	public DirectedEdge(int v, int w, double weight){
		if (v < 0) throw new IndexOutOfBoundsException("Vertex names must be nonnegative numbers");
		if (w < 0) throw new IndexOutOfBoundsException("Vertex names must be nonnegative numbers");
		if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is Nan");
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from(){
		return v;
	}
	
	public int to(){
		return w;
	}
	
	public double weight(){
		return weight;
	}
}
