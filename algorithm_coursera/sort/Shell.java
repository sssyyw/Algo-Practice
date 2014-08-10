package com.yiwei.sort;

public class Shell {
	
	public static void sort(Comparable[] a)
	{
		int h = 1;
		while (h < a.length/3) h = 3*h + 1;
		
		while(h>=1)
		{
		    for (int i = h; i < a.length; i++)
		    	for (int j = i; j >= h; j -= h)
		    		if (helper.less(a[j], a[j-h]))
		    			helper.exch(a, j-h, j);
		h = h/3;
		}
		assert helper.isSorted(a);
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
        sort(a);  
        for (Record item : a)
            System.out.println(item);
	}
}
