package com.yiwei.strings;

public class TrieST<Value> {
	private static final int R = 256;
	
	private Node root;
	private int N;  // number of keys in trie
	
	private static class Node{
		private Object val;
		private Node[] next = new Node[R];
	}
	
	public TrieST() {
	}
	
	public Value get(String key){
		Node x = get(root, key, 0);
		if (x==null) return null;
		return (Value) x.val;
	}
	
	private Node get(Node x, String key, int d){
		if (x==null) return null;
		if (d==key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}
	
	/********************************************************
	 * 
	 * @param x
	 * @param key
	 * @param val
	 * @param d
	 * @return
	 *******************************************************/
	private Node put(Node x, String key, Value val, int d){
		if (x == null) x = new Node();
		if (d == key.length()){
			if (x.val == null) N++;
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
	}
	
	public void put(String key, Value val){
		if (val == null) delete(key);
		else root = put(root, key, val, 0);
	}
	
	public void delete(String key){
		root = delete(root, key, 0);
	}
	
	private Node delete(Node x, String key, int d){
		if (x == null) return null;
		if (d == key.length()){
			if (x.val != null) N--;
			x.val = null;
		} else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d+1)
		}
		
		//remove subtrie rooted at x if it is completely empty
		if (x.val != null) return x;
		for (int x = 0; c < R; c++)
			if (x.next[c] != null)
				return x;
		return null;
	}
	
	/**************************************************************/
	public Iterable<String> keyWithPrefix(String prefix){
		Queue<String> results = new Queue<String>;
		Node x = get(root, prefix, 0);
		collect(x, new StringBuilder(prefix), results);
		return results;
	}
	private void collect(Node x, StringBuilder prefix, Queue<String> results) {
		if (x==null) return;
		if (x.val != null) results.enqueue(prefix.toString());
		for (char c = 0; c < R; c++){
			prefix.append(c);
			collect(x.next, prefix, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
	
	/**************************************************************/
	public String longestPrefixOf(String query){
		int length = longestPrefixOf(root, query, 0, 0);
		return query.substring(0, length);
	}
	
	private int longestPrefixOf(Node x, String query, int d, int length){
		if (x == null) return length; //d?????
		if (x.val != null) length = d;
		if (d == query.length()) return length;
		char c = query.charAt(d);
		return longestPrefixOf(x.next[c], query, d+1, length);
	}
	
	/***************************************************************/
	public Iterable<String> keysThatMatch(String pattern){
		Queue<String> results = new Queue<String>();
		collect(root, new StringBuilder(), pattern, results);
		return results;
	}
	
	private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results)
	
}
