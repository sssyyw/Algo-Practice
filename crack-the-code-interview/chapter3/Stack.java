package chapter3;

public class StackT {
	private Node top;
	public Object pop() {
		if (top != null){
			Object data = top.data;
			top = top.next;
			return data;
		}
		return null;
	}
	public void push(Object data){
		Node n1 = new Node(data);
		n1.next = top;
		top = n1;
	}
	
	private class Node{
		Object data;
		Node next;
		
		public Node(Object data){
			this.data = data;
		}
	}
	
}
