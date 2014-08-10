package com.yiwei.sort;


public class Selection {
	
	public static void sort(Comparable[] a)
	{
		for (int i = 0; i < a.length; i++)
		{   int min = i;	
			for (int j = i; j < a.length; j++)
			{
				if (helper.less(a[j], a[min]))
					min = j;
			}
			helper.exch(a, i, min);
		}
		assert helper.isSorted(a);
	}
	
	public static void main(String[] args)
	{
		Record[] a = new Record[2];
		a[0] = new Record("alex", "C");
		a[1] = new Record("mike", "A");
        sort(a);       
        System.out.println(a[0]);
			
	}

}
