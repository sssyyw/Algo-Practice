package chapter2;

import java.util.*;

public class LinkedList {
	
	//2.1,reference, previous operation was a big pain
	public static void removeDup(Node n){
		HashSet table = new HashSet();
		Node previous = n;
		
		while (n != null){
			if (table.contains(n.data))
				previous.next = n.next;
			else {
				table.add(n.data);
				previous = n; // previous catch up only when no dup
			}
			n = n.next;
		}
	}
	
	// no temp buffer is allowed
	public static void removeDup2(Node n){
		if (n == null) return;
		Node pre = n;
		Node head = n;
		while (n != null){
			Node itr = head;
			while (itr != n){
				if (n.data == itr.data){
					pre.next = n.next;
					break;
				}					
			    itr = itr.next;
			}
			if (itr == n)
				pre = n;
			n = n.next;
		}
	}
	
	// reference, same idea as mine
	public static void removeDup3(Node head){
		if (head == null) return;
		Node previous = head;
		Node current = previous.next;
		while(current != null){
			Node runner = head;
			while (runner != current){
				if (runner.data == current.data){
					previous.next = current.next;
					current = current.next;
					break;
				}
			    runner = runner.next;
			}
			
			if (runner == current){
				previous = current;
				current = current.next;
			}
			
		}
	}
	
	//2.2 reference, just beautiful
	LinkedListNode nthTolast(LinkedListNode head, int n){
		if (head == null || n < 1){
			return null;
		}	
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		for (int j = 0; j < n - 1; ++j){
			if (p2 == null){
				return null;
			}
			p2 = p2.next;
		}
		while (p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	//2.3  reference, copy the data
	public static boolean deleteNode(LinkedListNode n){
		if (n == null || n.next == null){
			return false;
		}
		while (n != null){
		    LinkedListNode next = n.next;
		    n.data = next.data;
		    n.next = next.next;
		    
		    n = n.next;
		}    
		return true;
				
	}
	
	//2.4 reference
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
		if (l1 == null && l2 == null){
			return null;
		}
		LinkedListNode result = new LinkedListNode(carry, null, null);
		
		int value = carry;
		if (l1 != null)
			value += l1.data;
		if (l2 != null)
			value += l2.data;
		result.data = value % 10;
		LinkedListNode more = addLists(l1 == null ? null: l1.next, l2 == null ? null : l2.next, value > 10 ? 1 : 0);
		
		result.setNext(more);
		return result;
	}
	
	//2.5 reference
	LinkedListNode FindBeginning(LinkedListNode head){
		LinkedListNode n1 = head;
		LinkedListNode n2 = head;
		// Find the meeting point
		while (n2.next != null){
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2){
				break;
			}
		}
		
		// Error check - there is no meeting point -> no loop
		if (n2.next == null){
			return null;
		}
		
		n1 = head; // what a remarkable idea!!!
		while(n1 != n2){
			n1 = n1.next;
			n2 = n2.next;
		}
		return n2;
	}
	
	
	
	
	

	
	
}
