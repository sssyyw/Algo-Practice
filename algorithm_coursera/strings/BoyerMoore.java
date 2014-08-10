package com.yiwei.strings;

public class BoyerMoore {
	private final int R;
	private int[] right;
	
	private char[] pattern;
	private String pat;
	
	public BoyerMoore(String pat){
		this.R = 256;
		this.pat = pat;
		
		right = new int[R];
		for (int c = 0; c < R; c++)
			right[c] = -1;
		for (int j = 0; j < pat.length(); j++)
			right[pat.charAt(j)] = j;
	}
}
