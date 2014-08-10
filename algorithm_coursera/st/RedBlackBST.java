package com.yiwei.st;

import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private boolean color;
		private int N;
		
		public Node(Key key, Value val, boolean color, int N){
			this.key = key;
			this.value = val;
			this.color = color;
			this.N = N;
		}
	}
	
	private boolean isRed(Node x){
		return x.color == RED;
	}
	
	public int size() {return size(root);}
	
	private int size(Node x){
		if (x == null) return 0;
	    return x.N;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
    /*******************************************************
    * 	Search
    ********************************************************/
	
	public Value get(Key key){
		return get(root, key);
	}
/*	
	private Value get(Node x, Key key){
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else 
			return x.value;
	}
*/
	private Value get(Node x, Key key){
		while(x != null){
			int cmp = key.compareTo(x.key);
			if (cmp < 0) x = x.left;
			else if (cmp > 0) x = x.right;
			else return x.value;
		}
		return null;
	}
	
	/******************************************************
	 * insertion
	 * ****************************************************/
	
	
	 private Node put(Node h, Key key, Value val){
		 if (h == null) return new Node(key, val, RED, 1);
		 int cmp = key.compareTo(h.key);
		 if (cmp < 0)
			 h = put(h.left, key, val);
	     else if (cmp > 0)
	    	 h = put(h.right, key, val);
	     else
	    	 h.value = val;
		 
		 // fix-up any right-leaning links
		 if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
		 if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		 if (isRed(h.left) && isRed(h.right)) flipColors(h);
		 
		 h.N = size(h.left) + size(h.right) + 1;
		 return h;
		 
	 }
	/********************************************************
	 * Helper
	 ********************************************************/
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = x.right.color;
		x.right.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}
	
    private Node rotateLeft(Node h){
    	Node x = h.right;
    	h.right = x.left;
    	x.left = h;
    	x.color = x.left.color;
    	x.left.color = RED;
    	x.N = h.N;
    	h.N = size(h.left) + size(h.right) + 1;
    	return x;
		
	}
    
    private void flipColors(Node h){
    	h.color = !h.color;
    	h.left.color = !h.left.color;
    	h.right.color = !h.right.color;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    private Node moveRedLeft(Node h){
    	flipColors(h);
    	if (isRed(h.right.left)){
    		h.right = rotateRight(h.right);
    		h = rotateLeft(h);
    	}
    	return h;
    }
}
