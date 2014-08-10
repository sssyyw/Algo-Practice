package com.yiwei.sort;

public class MergeSort {
	private MergeSort() {}
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		assert helper.isSorted(a, lo, mid);
		assert helper.isSorted(a, mid+1, hi);
		
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		int i = lo, j = mid + 1, k = lo;
		while (k <= hi)
		{
			if (i > mid)                          a[k++] = aux[j++]; // from aux to a, what a big mistake!
			else if (j > hi)                      a[k++] = aux[i++];
			else if (helper.less(aux[j], aux[i])) a[k++] = aux[j++];
			else                                  a[k++] = aux[i++];
		}
		assert helper.isSorted(a, lo, hi);
		
	
	}
	
	public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if (hi <= lo) return;  // two elements left
		
		int mid = (lo + hi)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
 
		
	}
	

	
	public static void main(String[] args)
	{
		Record[] a = new Record[6];
		a[0] = new Record("alex", "C");
		a[1] = new Record("mike", "A");
		a[2] = new Record("blex", "A-");
		a[3] = new Record("cike", "F");
		a[4] = new Record("dlex", "D");
		a[5] = new Record("dike", "B");
		
		Record[] aux = new Record[6];
        sort(a, aux, 0, a.length-1);  
        for (Record item : a)
            System.out.println(item);
	}

}
