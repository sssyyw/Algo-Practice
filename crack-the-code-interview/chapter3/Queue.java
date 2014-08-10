package chapter3;

public class Queue<Item> {
	private Node first, last;
	
	public void enqueue(Item item){
		Node oldLast = last;
		last = new Node(item);
		if (first == null)
			first = last;
		else 
			oldLast.next = last;
	}
	
	public Item dequeue(){
		if (first == null) return null;
		Item ret = first.item;
		first = first.next;
		return ret;
	}
	
	private class Node{
		Item item;
		Node next;
		
		public Node(Item item){
			this.item = item;
		}
	}

}
