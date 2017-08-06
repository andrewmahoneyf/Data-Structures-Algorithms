
public class ListQueue {
	private class Node{
		String data;
		Node next;
		
		Node(String s){
			data = s;
		}
	}
	
	//Class variables here, if necessary
	private Node first, last;
	
	public ListQueue(){
		first = null;
		last = null;
	}
	
	// This function should take the string toInput and insert it at the back of the 
	// queue. This will need to manipulate instances of the private Node class
	public void enqueue(String toInput) {
		Node temp = last;
		last = new Node(toInput);
		last.next = null;
		if (first == null) first = last;
		else temp.next = last;
	}
	
	// This function returns the first item in the queue and removes that element 
	// from the queue. If the queue is empty, dequeue() should return null.
	public String dequeue(){
		if (first == null) return null;
		if (first == last) {
			String item = first.data;
			first = last = null;
			return item;
		}
		String item = first.data;
		first = first.next;
		return item;
	}
	
	//  This function returns the first item in the queue while keeping that item in 
	// the queue (preserving its place). If the queue is empty, front() should return null
	public String front(){
		if (first == null) return null;
		return first.data;
	} 
}
