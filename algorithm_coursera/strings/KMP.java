package com.yiwei.strings;

public class KMP {
	private final int R;
	private int [][] dfa;
	
	private char[] pattern;
	private String pat;
	
	public KMP(String pat){
		this.pat = pat;
		M = pat.length();
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		
		for (int X = 0, j = 1; j < M; j++){
			// copy mismatch cases
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X];
			// set match cases
			dfa[pat.charAt(j)][j] = j + 1;
			// update restart state
			X = dfa[pat.charAt(j)][X];
		}
	}
}
