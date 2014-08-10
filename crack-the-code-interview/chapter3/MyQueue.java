package chapter3;

import java.util.Stack;

public class MyQueue<T> {
	private Stack<T> stackIn;
	private Stack<T> stackOut;
	
	public MyQueue(){
		stackIn = new Stack<T>();
		stackOut = new Stack<T>();
	}
	
	public int size() {
		return stackIn.size() + stackOut.size();
	}
	
	public void enqueue(T v){
		stackIn.push(v);
	}
	
	public T peek(){
		if (stackOut.isEmpty()) move();
		return stackOut.peek();
	}
	
	public T dequeue(){
		if (stackOut.isEmpty()) move();
		return stackOut.pop();
	}
	
	private void move(){
		while (!stackIn.isEmpty())
		    stackOut.push(stackIn.pop());
	}
	
}
