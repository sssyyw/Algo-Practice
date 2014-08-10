package chapter9;

public class General {

	//9.1 
	public static void merge(int[] a, int[] b){
		int[] c = new int[a.length];
		for (int i = 0; i < a.length; ++i){
			c[i] = a[i];
		}
		
		for (int k = 0, i = 0, j = 0; k < a.length; k++){
		    if (j >= b.length)
			    a[k] = a[i++];
		    else if (c[i] <= b[j])
			    a[k] = a[i++];
		    else
			    a[k] = b[j++];
		}
	}
	// reference
	public static void merge2(int[] a, int[] b, int n, int m){
		int k = m + n - 1;
		int i = n - 1;
		int j = m - 1;
		
		// doing it from back if a is large enough is a smart way!!
		while(i >= 0 && j>= 0){
			if (a[i] > b[j]){
				a[k--] = a[i--];
			} else {
				a[k--] = a[j--];
			}
		}
		// do not need to do this for i because they are already there.
		while (j >= 0){  
			a[k--] = b[j--];
		}
	}
	
	// 9.3 reference
	public static int search(int a[], int l, int u, int x){
		while (l <= u){
			int m = (l + u) / 2;
			if (x == a[m]){
				return m;
			// rotation at a[m]'s right or left
			// x has three possible positions in 
			// each situation.
			// use the comparison with a[m], a[l], a[u]
			// to narrow down x.
			} else if (a[l] <= a[m]){
				if (x > a[m]){
					l = m + 1;
				} else if (x >= a[l]){
					u = m - 1;
				} else {
					l = m + 1;
				}
			} 
			else if (x < a[m]) u = m - 1;
			else if (x <= a[u]) l = m + 1;
			else u = m - 1;
		}
		return -1;
	}
	public static int search(int a[], int x){
		return search(a, 0, a.length-1, x);
	}
	
	//9.5
	// I was not aware this wrapper should be like this...
	public static int findString(String[] a, String x){
		if (a == null || x == null) return -1;
		if (x == ""){
			for (int i = 0; i < a.length; i++)
				if (a[i] == "")
					return i;
			return -1;
		}
		return findString(a, 0, a.length-1, x);
	}
	
	public static int findString(String[] a, int l, int u, String x){
		if (l > u)
			return -1;
		// here's my missing part which makes sure ++m 
		// always find one
		while (a[u] == "")
			--u;
		int m = (1 + u) >> 1;
		// search at right of m to avoid empty string
		while (a[m] == "")
			++m;
		int tmp = x.compareTo(a[m]);
	    if (tmp == 0)
	    	return m;
	    else if (tmp < 0)
	    	return findString(a, 0, m-1, x);
	    else 
	    	return findString(a, m+1, u, x);
	}
	
	//9.6
	public static Point findEle(int[][] a, int m1, int m2, int n1, int n2, int x){
		if (m1 > m2 || n1 > n2)
			return null;
		if (m2 - m1 == 1){
			
		}
        if (n2 - n1 == 1){
			
		}
		int midm = (m1 + m2) >> 1;
		int midn = (n1 + n2) >> 1;
		
		int tmp = a[midm][midn];
		if (x == tmp)
			return Point(midm, midn);
		else if (x < tmp)
			return findEle(a, m1, midm, n1, midn, x);
		else
			return findEle(a, midm, m2, midn, n2, x);
	}
	
	// reference, my answer above sucks. 
	// look at this row = 0, and col = N-1's great idea!!!
	public boolean findElem(int[][] mat, int elem, int M, int N){
		int row = 0;
		int col = N-1;
		while (row < M && col >= 0){
			if (mat[row][col] == elem){
				return true;
			} else if (mat[row][col] > elem){
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
	
}
