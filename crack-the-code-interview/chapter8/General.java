package chapter8;

import java.util.ArrayList;

public class General {
    //8.1 It's not that naive, two base cases
	public static int Fibonacci(int N){
		if (N == 0)
			return 0;
		else if (N == 1)   // be careful
			return 1;
		else 
		    return Fibonacci(N - 1) + Fibonacci(N - 2);
	}
	
	// iterative, it's not necessary to use an array
	public static int fib_iter(int n){
		int[] results = new int[n + 1];
		results[0] = 0;
		results[1] = 1;
		for (int i = 2; i < n + 1; i++){
			results[i] = results[i-1] + results[i-2];
		}
		return results[n];
	}
	
	// reference
	public static int fib_iter2(int n){
		if (n == 0) return 0;
		int a = 1, b = 1;
		for (int i = 3; i <= n; i++){
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
/*	
	// 8.2 reference
	ArrayList<Point> current_path = new ArrayList<Point>();
	public static boolean getPaths(int x, int y){
		Point p = new Point(x, y);
		current_path.add(p);
		if (x == 0 && y == 0) return true;
		boolean success = false;
		// Note: this is "if" not "if else" with "return"
		// at bottom. It searches all the paths.
		if (x >= 1 && is_free(x-1, y)){
			success = getPaths(x-1, y);
		}
		if (!success && y >= 1 && is_free(x, y-1)){
			success = getPaths(x, y-1);
		}
		if (!success){
			current_path.remove(p);
		}
		return success;
	}
*/	
	//8.3 reference #1 Recursion
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index){ // base case
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		} else {
			allsubsets = getSubsets(set, index + 1); // suppose we did previous one
			int item = set.get(index); // get new item
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset: allsubsets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset); // new listsets combining the previous one and item
			}
			allsubsets.addAll(moresubsets); // "merge" back to allsubsets.
		}
		return allsubsets;
	}
	// reference #2 Combinatorics
	ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); // total of the combinations 2^n
		for (int i = 0; i < max; i++){ // for each number that is a 0/1 digits
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			while (k > 0){ //check each bit of i, if it's 1, put the corresponding number in this subset
				if ((k & 1) > 0){
					subset.add(set.get(index));
				}
				k >>= 1;
		        index++;
			}
		    allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	//8.4 reference
	public static ArrayList<String> getPerms(String s){
		ArrayList<String> permutations = new ArrayList<String>();
		if (s == null){
			return null;
		} else if (s.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		
		char first = s.charAt(0);
		String remainder = s.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for (String word: words){
			// the accuracy of this for loop is crucial
			for (int j = 0; j <= word.length(); j++){
				permutations.add(insertCharAt(word, first, j));
			}
		}
		return permutations;
	}
	
	public static String insertCharAt(String word, char c, int i){
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	// 8.5 reference
	private static void printPar(int l, int r, char[] str, int count){
		if (l < 0 || r < l) return; // invalid
		if (l == 0 && r == 0){
			System.out.println(str); // found one, print it
		} else {
			if (l > 0){
				str[count] = '(';
				printPar(l-1, r, str, count+1);
			}
			if (r > l){
				str[count] = ')';
				printPar(l, r-1, str, count+1);
			}
		}
	}
	public static void printPar(int count){
		char[] str = new char[count*2];
		printPar(count, count, str, 0);
	}
	
	//8.6 reference
	enum Color {
		Black, White, Red, Yellow, Green
	}
	private boolean PaintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length)
			return false;
		if (screen[y][x] == ocolor){
			screen[y][x] = ncolor;
			PaintFill(screen, x-1, y, ocolor, ncolor);
			PaintFill(screen, x+1, y, ocolor, ncolor);
			PaintFill(screen, x, y-1, ocolor, ncolor);
			PaintFill(screen, x, y+1, ocolor, ncolor);
		}
		return true;
	}
	public boolean PaintFill(Color[][] screen, int x, int y, Color ncolor){
		return PaintFill(screen, x, y, screen[y][x], ncolor);
	}
	// 8.7
	public static ArrayList<int[]> nRep(int n){
		ArrayList<int[]> al = new ArrayList<int[]>();
		nRep(al, n, 0, 0, 0, 0);
		return al;
	}
	
	private static void nRep(ArrayList<int[]> al, int n, int quars, int dimes, int nickels, int pennies){
		if (quars*25 + dimes*10 + nickels*5 + pennies == n){
			int[] temp = {quars, dimes, nickels, pennies};
			al.add(temp);
			return;
		}
					
		if ((n - quars*25) >= 25)
			nRep(al, n, quars+1, dimes, nickels, pennies);
		if ((n - quars*25 - dimes*10) >= 10)
		    nRep(al, n, quars, dimes+1, nickels, pennies);
		if ((n - quars*25 - dimes*10 - nickels*5) >= 5)
		    nRep(al, n, quars, dimes, nickels+1, pennies);
		if ((n - quars*25 - dimes*10 - nickels*5 * pennies) >= 1)
		    nRep(al, n, quars, dimes, nickels, pennies+1);
	}
	
	// reference
	public static int makeChange(int n, int denom){
		int next_denom = 0;
		switch(denom){
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++){
			ways += makeChange(n - 1*denom, next_denom);
		}
		return ways;
	}
	
	//8.8 reference
	int columnForRow[] = new int[8];
	boolean check(int row){
		for (int i = 0; i < row; i++){
			int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			if (diff == 0 || diff == row - i) return false;
		}
		return true;
	}
	
	void PlaceQueen(int row){
		if (row == 8){
			printBoard();
			return;
		}
		for (int i = 0; i < 8; i++){
			columnForRow[row]=i;
			if (check(row)){
				PlaceQueen(row+1);
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println(makeChange(100, 25));
		//System.out.println(nRep(100).size());
	}
}
