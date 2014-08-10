package com.yiwei.st;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
	
	private Node root = null;
	
	private class Node {
		// private
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int N;               // ***number of nodes in subtree (for size and rank?)
		
		// constructor
		public Node (Key key, Value val, int N){
			this.key = key;
			this.value = val;
			this.N = N;
		}
	}
	/****************************************
	 * added for orded ops
	 ****************************************/
     public boolean isEmpty(){
    	 return size() == 0;
     }
     
     public int size(){
    	 return size(root);
     }
     
     private int size(Node x){      
    	 if (x == null) return 0;
    	 else return x.N;
     }
	
	/********************************************************
	 * General API
	 * ******************************************************/

	public void put(Key x, Value v){
		root = put(root, x, v);     //***Must reassign root to deal with null root case
	}
	
	private Node put(Node x, Key key, Value v){ //***do not make mistake and confusion by reusing "root"
		if (x == null)
		    return new Node(key, v, 1);  // Do not be that lazy to skip the constructor
		
		int cmp = key.compareTo(x.key);
		if (cmp < 0){
			x.left = put(x.left, key, v);
		} else if (cmp > 0) {
			x.right = put(x.right, key, v);
		} else {
			x.value = v;	
		}
		
		// update N
		x.N = 1 + size(x.left) + size(x.right);
		
		return x;	
	}
	
	public Value get(Key x){
		return get(root, x);
	}
	
	private Value get(Node x, Key key){ //***do not make mistake and confusion by reusing "root"
		if (x == null)
			return null;
		
		int cmp = key.compareTo(x.key); // my code was not concise 
		
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.value;
	}
	

	
	public boolean contains(Key x){
		return !(get(x) == null);
	}
	
	public void delete(Key x){
		root = delete(root, x);           //again, reassign root
	}
	
	private Node delete(Node x, Key key){ //***do not make mistake and confusion by reusing "root"
		if (x == null)
			return null;
		
		int cmd = key.compareTo(x.key);
		if (cmd < 0)
			x.left =  delete(x.left, key);
		else if (cmd > 0)
			x.right =  delete(x.right, key);
		else {                            //**********I was totally wrong in this crucial part.
			if (x.right == null) return x.left;
			if (x.left == null) return x.right;
			Node t = x;                    
			x = min(t.right);             // pick up the smallest of the right subtree
			x.right = deleteMin(t.right);  
			x.left = t.left;
		}	
		
		x.N = size(x.left) + size(x.right);
		return x;
	}
	
	/********************************************
	 * deleteMin/Max is supportive func of delete
	 ********************************************/
	
	public void deleteMin(){
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
		root = deleteMin(root);      // again reassign root
	}
	
	private Node deleteMin(Node x) { // use recursion
		if (x.left == null) return x.right;  // *******Key operation to delete and reassign -- return x.right!!
		x.left = deleteMin(x.left);          // ********
		
		x.N = size(x.left) + size(x.right) + 1;  // same experssion
	
		return x;

	}
	
	public void deleteMax(){
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
		root = deleteMax(root);      // again reassign root
	}
	
	private Node deleteMax(Node x) { // use recursion
		if (x.right == null) return x.left;  // Key operation to delete and reassign -- return x.right!!
		x.right = deleteMin(x.right);
		
		x.N = size(x.left) + size(x.right) + 1;  // same experssion
		return x;

	}
	
	public Key min(){
		if (isEmpty()) return null;
		return min(root).key;
	}
	
	private Node min(Node x) {
		if (x.left == null) return x;
		else return min(x.left);
	}
	
	public Key max(){
		if (isEmpty()) return null;
		return max(root).key;
	}
	
	private Node max(Node x) {
		if (x.right == null) return x;
		else return max(x.right);
	}
	
	/********************************************************
	 * ordered operations
	 * ******************************************************/
	
	/********************************************************
	 * floor, ceiling, 
	 ********************************************************/
     public Key floor(Key key){
    	 Node x = floor(root, key);
    	 if (x==null) return null;
    	 else return x.key;
     }
     
     private Node floor(Node x, Key key){
    	 if (x == null) return null;
    	 
    	 int cmp = key.compareTo(x.key);
    	 if (cmp == 0) return x;
    	 if (cmp < 0) return floor(x.left, key);
    	 /***notice below***/
    	 Node t = floor(x.right, key);
    	 if (t != null) return t;   // *****these is a x < k int right subtree
    	 else return x;             // *****otherwise return root
     }
     
     public Key ceiling(Key key){
    	 Node x = floor(root, key);
    	 if (x==null) return null;
    	 else return x.key;
     }
     
     private Node ceiling(Node x, Key key){
    	 if (x == null) return null;
    	 
    	 int cmp = key.compareTo(x.key);
    	 if (cmp == 0) return x;
    	 if (cmp > 0) return ceiling(x.right, key);
    	 /***notice below***/
    	 Node t = ceiling(x.left, key);
    	 if (t != null) return t;   // *****these is a x < k int right subtree
    	 else return x;             // *****otherwise return root
     }
     
 	/********************************************************
 	 * rank, selection
 	 ********************************************************/
    public Key select(int k){
    	if (k<0 || k >= size()) return null;
    	Node x = select(root, k);
    	return x.key;
    }
     
	private Node select(Node x, int k){ // select the kth
		if (x == null) return null;
		int t = size(x.left);
		if (t > k) return select(x.left, k);
		else if (t < k) return select(x.right, k-t-1);  //k-t-1
		else return x;
	}
	
	// number of keys in the subtree less than key. (if key is root node, than it's subtree size)
	public int rank(Key key) {
		return rank(key, root);
	}
	
	private int rank(Key key, Node x){
		if (x == null) return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return rank(key, x.left);
		else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);  // 3 parts added
		else return size(x.left);
	}
  	/********************************************************
  	 * range count and range search.  height
  	 ********************************************************/
     public Iterable<Key> keys(){
    	 return keys(min(), max());
     }
     
     public Iterable<Key> keys(Key lo, Key hi){
    	 Queue<Key> queue = new Queue<Key>();
    	 key(root, queue, lo, hi);
    	 return queue;
     }
     
     private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
    	 if (x == null) return;
    	 int cmplo = lo.compareTo(x.key);
    	 int cmphi = hi.compareTo(x.key);
    	 if (cmplo < 0) keys(x.left, queue, lo, hi);
    	 if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
    	 if (cmphi > 0) keys(x.right, queue, lo, hi);
     }
     
     public int size(Key lo, Key hi){
    	 if (lo.compareTo(hi) > 0) return 0;
    	 if (contains(hi)) return rank(hi) - rank(lo) + 1;
    	 else              return rank(hi) - rank(lo);
     }
  	/********************************************************
  	 * height
  	 ********************************************************/
     public int height(){
    	 return height(root);
     }
     
     private int height(Node x){
    	 if (x==null) return -1;
    	 return 1 + Math.max(height(x.left), height(x.right));
     }
     
     public Iterable<Key> levelOrder() {
    	 Queue<Key> keys = new Queue<Key>();
    	 Queue<Node> queue = new Queue<Node>();
    	 queue.enqueue(root);
    	 while (!queue.isEmpty()){
    		 Node x = queue.dequeue();
    		 if (x == null) continue;
    		 keys.enqueue(x.key);
    		 queue.enqueue(x.left);
    		 queue.enqueue(x.right);
    	 }
    	 return keys;
     }
	/********************************************************
	 * helper functions
	 * ******************************************************/
	private boolean less(Key x, Key y){
		return x.compareTo(y) < 0;
	}
	 
}
