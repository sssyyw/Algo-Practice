package com.yiwei.sort;

public class Insertion {
	
	public static void sort(Comparable[] a)
	{
		for (int i = 0; i < a.length; i++)
			for (int j = i; j > 0; j--)
				if (helper.less(a[j], a[j-1]))
					helper.exch(a, j, j-1);
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
