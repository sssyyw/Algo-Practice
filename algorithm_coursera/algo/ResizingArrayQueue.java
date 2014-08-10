package com.yiwei.algo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> 
{
	private Item[] a;
	private int head = 0, tail = 0, N = 0;
	
	public ResizingArrayQueue()
	{
		a = (Item[]) new Object[2];    //the ugly cast, generic array is not allowed
	}
	
	public void enqueue(Item in)
	{
		if (N== a.length) resize(a.length*2);
		a[tail++] = in;
		if (tail == a.length) tail = 0;            //*		
		N++;
			
	}
	
	private void resize(int cap)
	{
		Item[] temp = (Item[]) new Object[cap];  //
		for (int i = 0; i < N; i++)
			temp[i] = a[(head + i) % a.length];                 //****
		a = temp;
		head = 0;
		tail = N;                                               //*
	}
	
	public Item dequeue()
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		
		Item out = a[head];
		a[head] = null;
		head++;
		N--;
		if (head == a.length) head = 0;  //*
		if (N > 0 && N == a.length/4)
			resize(a.length/2);          //*
		return out;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public static void main(String[] args)
	{
		ResizingArrayQueue<String> q = new ResizingArrayQueue<String>();
		q.enqueue("Hi");
		q.enqueue(("-"));
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
