package com.yiwei.strings;

public class General {
	public static int lcp(String s, String t){
        int count = 0;
        int shortLength = (s.length() < t.length()) ? s.length(): t.length();
		for (int i = 0; i < shortLength; i++){
			if (s.charAt(i) == t.charAt(i))
				count++;
			else
				return count;
		}
		return count;
	}
	
	public static int lcp2(String s, String t){
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++){
			if (s.charAt(i) != t.charAt(i))
				return i;
		}
		return N;             // Note!!!
	}
}
