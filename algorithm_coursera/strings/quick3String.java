package com.yiwei.strings;

public class quick3String {
	   private static void sort(String[] a, int lo, int hi, int d) { 

	        // cutoff to insertion sort for small subarrays
	        if (hi <= lo + CUTOFF) {
	            insertion(a, lo, hi, d);
	            return;
	        }

	        int lt = lo, gt = hi;
	        int v = charAt(a[lo], d);
	        int i = lo + 1;
	        while (i <= gt) {
	            int t = charAt(a[i], d);
	            if      (t < v) exch(a, lt++, i++);
	            else if (t > v) exch(a, i, gt--);
	            else              i++;
	        }

	        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
	        sort(a, lo, lt-1, d);
	        if (v >= 0) sort(a, lt, gt, d+1);
	        sort(a, gt+1, hi, d);
	    }

}
