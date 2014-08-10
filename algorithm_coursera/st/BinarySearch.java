package com.yiwei.st;

public class BinarySearch {
	
	/* iterative */
	public static int bs(int[] a, int key, int lo, int hi){
		while (lo <= hi){
			int mid = (lo + hi)/2;
			if (a[mid] > key)
				hi = mid - 1;
			else if (a[mid] < key)
				lo = mid + 1;
			else 
				return mid;
		}
		return -1;		
	}
	
	/* recursive */
    public static int bs_rec(int[] a, int key, int lo, int hi){
    	if (hi < lo)
    		return -1;
    	int mid = (lo + hi)/2;
    	if (a[mid] > key)
    		return bs_rec(a, key, lo, mid-1);
    	else if (a[mid] < key)
    		return bs_rec(a, key, mid+1, hi);
    	else
    		return mid;
    }
}
