package com.yiwei.sort;

import java.util.Comparator;

public class helper {
	
	public static boolean less (Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	public static boolean less (Comparator c, Comparable v, Comparable w)
	{
		return c.compare(v, w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j)
	{
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static boolean isSorted(Comparable[] a)
	{
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}
	
	public static boolean isSorted(Comparable[] a, int lo, int hi)
	{
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}
}
