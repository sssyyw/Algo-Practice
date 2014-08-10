package chapter1;

import java.util.*;

public class HW {
	
	//1.1, if additional data structure cannot be used, then use double loop
	//     or quicksort and then checking adjacent chars
	
	// this method is good esp string of numbers?
	public boolean uniqueChar(String x){
		HashSet<Character> hset = new HashSet<Character>();
		for (int i = 0; i <= x.length(); i++){
			if (hset.contains(x.charAt(i)))
				return true;
			else
				hset.add(x.charAt(i));
		}
		return false;
	}
	
	// reference 1
	public static boolean isUniqueChars(String str){
		boolean[] pool = new boolean[256];
		// need init to false???
		for (int i = 0; i < str.length(); i++){
			if (pool[str.charAt(i)])
				return false;
			else 
			    pool[str.charAt(i)] = true;
		}
		return true;
	}
	// reference 2. this is interesting.
	public static boolean isUniqueChars2(String str){
		int checker = 0;
		for (int i = 0; i < str.length(); ++i){
			int var = str.charAt(i) - 'a';
			 if ((checker & (1 << var)) > 0)
				 return false;
			 checker = checker | (1 << var);
		}
		return true;
	}
	
	//1.3 My attempt screwed up. This is reference 1.
	public static void removeDuplicates(char[] str){
		if (str == null) return;
		int len = str.length;	
        if (len < 2) return;
        
        int tail = 1;
        
        for (int i = 1; i < len; ++i){
        	int j;
        	for (j = 0; j < tail; ++j){
        		if (str[i] == str[j]) break;
        	}
        	if (j == tail){
        		str[tail] = str[i];
        		++tail;
        	}
        }
        if (tail != len)
            str[tail] = 0;
	}
	
	// reference 2, with additional memory of constant size
	public static void removeDuplicatesEff(char[] str){
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i){
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		
		for (int i = 1; i < len; ++i){
			if (!hit[str[i]]){
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		//if (tail != len)
		    str[tail] = 0;
	}
	
	//1.4 anagrams, SORT the string is an easy way to do that...
	public static boolean anagrams(String w1, String w2){
		int N = w1.length();
		int M = w2.length();
		if (N != M) return false;
		
		HashMap<Character, Integer> mem = new HashMap<Character, Integer>();
		int temp;
		for (int i = 0; i < N; i++){
			if ((temp = mem.get(w1.charAt(i))) != 0)
			    mem.put(w1.charAt(i), temp+1);
			else
				mem.put(w1.charAt(i), 0);	
		}
		
		for (int i = 0; i < N; i++){
			if ((temp = mem.get(w1.charAt(i))) == 0)
				return false; 
			mem.put(w1.charAt(i), temp-1);
		}
		return true;
	}
	
	// reference -- the same idea as my solution, but checking identical counts using index-counting array
	public static boolean anagram(String s, String t){
		if (s.length() != t.length()) return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c: s_array){
			if (letters[c] == 0) ++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i){
			int c = (int) t.charAt(i);
			if (letters[c] == 0)
				return false;
			
			--letters[c];
			
			if (letters[c] == 0){  // is this necessary?
				++num_completed_t;
				if (num_completed_t == num_unique_chars){
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}
	
	//1.5 
	public static void replaceFun(char[] str, int length){
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++){
			if (str[i] == ' '){
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2; // add 2x extra 
		str[newLength] = '\0';
		for (i = length-1; i >= 0; i--){     // cal the len and backward setting
			if (str[i] == ' '){
				str[newLength - 1] = '0';
				str[newLength - 1] = '2';
				str[newLength - 1] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}
	
	// 1.6
	public static void rotate90(int[][] mat, int N){
		for (int i = 0; i < N; i++){
			for (int j = i + 1; j < N; j++){
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		
		for (int i = 0; i < N/2; i++){
			for (int j = 0; j < N; j++){
				int temp = mat[i][j];
				mat[i][j] = mat[N-i-1][j];
				mat[N-i-1][j] = temp;
			}
		}
	}
	
	// reference uses four-way swap. maybe it's a little bit efficient.
			
	// 1.7, ThereÕs one problem with that solution though: 
	// we will ÒrecognizeÓ those 0s later on in our iteration 
	// and then set their row and column to zero Pretty soon, 
	// our entire matrix is 0s! So, use extra O(MN) spaces? No. see ref.
	public static void set0(int[][] mat){		
		for (int i = 0; i < mat.length; i++){
			for (int j = 0; j < mat[i].length; j++){
				if (mat[i][j] == 0){
					for (int k = 0; k < mat[i].length; k++)
						mat[i][k] = 0;
					for (int k = 0; k < mat.length; k++)
						mat[k][j] = 0;
					break;
				}
			}
		}
	}
	
	//reference
	public static void setZeros(int[][] matrix){
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		// store
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				if (matrix[i][j] == 0){
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		
		// set 0 if
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				if (row[i] == 1 || column[j] == 1){
					matrix[i][j] = 0;
				}
			}
		}
		
	}
	
	//1.8, reference -- concatenate s1 with itself and see whether s2 is substring of the result	
	public static boolean isRotation(String s1, String s2){
		int len = s1.length();
		if (len == s2.length() && len > 0){
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
	
	
	public static void main(String[] args){
/*		String[] testCases = {"aaaaaaybbbfagcd"};
		for (int i = 0; i < testCases.length && testCases[i] != null; i++){
			char[] temp = testCases[i].toCharArray();
		    removeDuplicatesEff(temp);
		}
	}
*/
		int[][] a = {{1, 2, 3}, {4, 5, 6}, {0, 8, 9}};
		set0(a);
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++)
		        System.out.print(a[i][j]);
		    System.out.print('\n');
		}   
	}
}
