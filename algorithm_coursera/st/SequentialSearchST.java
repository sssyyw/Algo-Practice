package com.yiwei.st;

public class SequentialSearchST<Key, Value> {
	private int N;
	private Node first;
	
	private class Node{
		private Key key;
		private Value val;
		private Node next;
		
		public Node(Key key, Value val, Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public boolean contains(Key key){
		return get(key) != null;
	}
	
	public Value get(Key key){
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key))
				return x.val;
		return null;
	}
	
	public void put(Key key, Value val){
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)){
				x.val = val;
				return;
			}
		first = new Node(key, val, first); //***********
		N++;				
	}
	
	public void delete(Key key){
		first = delete(first, key);
	}
	private Node delete(Node x, Key key){
		if (x==null) return null;
		if (key.equals(x.key)) {
			N--; 
			return x.next;
		}
		x.next = delete(x.next, key);    //*******************************
		return x;
	}
	
	/***
	 //how to deal with the recursive difficulties here?
	public void delete_rec(Node x, Key key){
		if (x==null) return;
		for (Node node = x; node != null; node = node.next)
			if (key.equals(node.key))
				
	}
	
	***/
}
