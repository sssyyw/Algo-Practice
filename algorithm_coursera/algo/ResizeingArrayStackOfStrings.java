package com.yiwei.algo;

import java.util.NoSuchElementException;

public class ResizeingArrayStackOfStrings 
{
    private String[] s;
    private int N = 0;
    
	public ResizeingArrayStackOfStrings()
	{
		s = new String[1];
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public void push(String input)
	{
		if (N == s.length)
			resize(N * 2);
		s[N++] = input;
	}
	
	public String pop()
	{
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");  //*
		
		String output = s[N-1];
		s[N-1] = null;  //*
		N--;
		if (N > 0 && N * 4 == s.length)
			resize(N * 2);
		return output;
	}
	
	private void resize(int size)
	{
		assert size >= N;
		String[] sOld = s;
		s = new String[size];
		for (int i = 0; i < N; i++)
			s[i] = sOld[i];
		// ? sOld = null;
	}
	
	public static void main(String[] args)
	{
		
	}
}
