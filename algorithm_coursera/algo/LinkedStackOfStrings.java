package com.yiwei.algo;

import java.util.Iterator;

public class LinkedStackOfStrings<Item> implements Iterable<Item>
{
	private Node first = null;
	
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext() {return current != null;}
		public void remove() {}
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void pr()
		{
			System.out.println("hoho");
		}
	}
	
	private class Node 
	{
		Item item;
		Node next;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public void push(Item input)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = input;
		first.next = oldfirst;
	}
	
	public Item pop()
	{
		if (isEmpty())
			return null;
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public static void main(String[] args)
	{
		LinkedStackOfStrings<String> s = new LinkedStackOfStrings<String>();
		s.push("SYW");
		Iterator<String> it = s.iterator();
		System.out.println(it.next());
		System.out.println(s);
	}

}
