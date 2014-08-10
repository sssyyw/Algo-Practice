package com.yiwei.sort;

public class Heap {
	public static void sort(Comparable[] pq){
		int N = pq.length;
		for (int k= N/2; k>= 1; k--)   //build
			sink(pq, k, N);
		while (N > 1){
			exch(pq, 1, N--);
			sink(pq, 1, N);
		}
	}
}
