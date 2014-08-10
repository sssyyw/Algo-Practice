package com.yiwei.sort;

public class Quick {
	
	public static void sort3way(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int lt = lo, gt = hi;
		Comparable v = a[lo];
		int i = lo;
		while(i<=gt)
		{
			int cmp = a[i].compareTo(v);
			if      (cmp < 0) helper.exch(a, lt++, i++);
			else if (cmp > 0) helper.exch(a, i, gt--);
			else              i++;
		}
		
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
	
	public static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j);
		sort(a, j+1, hi);
	}
	
	public static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo, j = hi + 1;
		while (true)
		{
			/*find item on left to swap*/
			while (helper.less(a[++i], a[lo]))
				if (i == hi) break;
			/*find item on right to swap*/
			while (helper.less(a[lo], a[--j]))
				if (j == lo) break;
			
			if (i >= j) break;
			helper.exch(a, i, j);
		}
		
		helper.exch(a, lo, j);
		return j;
	}
	
	public static void shuffle(Comparable[] a)
	{
		
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
		
		//Record[] aux = new Record[6];
        sort(a, 0, a.length-1);  
        for (Record item : a)
            System.out.println(item);
	}

}
