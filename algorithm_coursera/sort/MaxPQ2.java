package com.yiwei.sort;


public class MaxPQ2 {
	private Comparable[] pq;
	private int N;
	
	public MaxPQ2(int cap)
	{
		pq = new Comparable[cap+1];      // heap array should start with 1 to keep the
		N = 0;                           // parent-child relation simple
	}
	
	public MaxPQ2(Comparable[] keys)
	{
		N = keys.length;
		pq = new Comparable[N+1]; 
		for (int i = 0; i < N; i++)
			this.pq[i+1] = keys[i];
		for (int k = N/2; k >= 1; k--)
			sink(k);
	}
	
	public void insert(Comparable x)
	{
		if (N >= pq.length - 1) resize(2* pq.length);
		
		pq[++N] = x;
		swim(N);
	}
	
	public Comparable delMax()
	{
		Comparable max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N+1] = null;
		if (N>0 && N==(pq.length - 1)/4)
			resize(pq.length/2);
		return max;
	}
	
	private void resize(int capacity){
		Comparable[] temp = new Comparable[capacity];
		for (int i = 1; i <= N; i++) temp[i] = pq[i];
		pq = temp;
	}
	
	/*************************************************************************
	 * Helper Func.
	 * ***********************************************************************/
	private void sink(int k)
	{
		while (2*k < N)
		{
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	private void swim(int k)
	{
		while(k>1)
		{
			if (less(k/2, k))
				exch(k, k/2);
			k = k/2;
		}
	}
	
	private boolean less(int i, int j)
	{

		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j)
	{
		Comparable swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
	public int size(){
		return N;
	}
}
