package com.yiwei.algo;

public class linkedQueueOfStrings {
	
	private Node first, last;
	
	private class Node 
	{
		String item;
		Node next;
	}
	
	public void enqueue(String in)
	{
		Node oldlast = last;
		last = new Node();
		last.item = in;
		last.next = null;
		if (isEmpty()) first = last;  //*
		else oldlast.next = last;
	}
	
	public String dequeue()
	{
		String out = first.item;
		first = first.next;
		if(isEmpty()) last = null;   //*
		return out;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}

	public static void main(String[] args)
	{
		linkedQueueOfStrings q = new linkedQueueOfStrings();
		q.enqueue("Hi");
		q.enqueue(("-"));
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
