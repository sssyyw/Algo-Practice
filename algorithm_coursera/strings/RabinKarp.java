package com.yiwei.strings;

public class RabinKarp {
	public RabinKarp(String pat){
		this.pat = pat;
		R = 256;
		M = pat.length();
		Q = longRandomPrime();
		
		RM = 1;
		for (int i = 1; i <= M-1; i++)
			RM = (R * RM) % Q;
		patHash = hash(pat, M);
	}
}
