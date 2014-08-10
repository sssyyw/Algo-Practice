package chapter9;

import java.util.Arrays;

public class AnagramComparator implements Comparator<String>{
	public String sortChars(String s){
		char[] content = s.toCharArray();
		// the most difficult part has been avoided,
		// here some alg like 3-way radix quick sort
		// should be used.
		Arrays.sort(content);
		return new String(content);
	}
	
	public int compare(String s1, String s2){
		return sortChars(s1).compareTo(sortChars(s2));
	}
	
	public static void main(String[] args){
		Arrays.sort(array, new AnagramComparator());
	}
}
