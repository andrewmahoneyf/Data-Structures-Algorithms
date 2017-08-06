public class ULLDict implements Dictionary {
	private class Node {
		private String data;
		private int key;
		private Node next;

		Node(int i, String s) {
			key = i;
			data = s;
		}
	}

	private Node first, last;

	// if empty makes first node point at last, then adds to .next every insert
	// after
	public void insert(int key, String value) {
		Node temp = last;
		last = new Node(key, value);
		last.next = null;
		if (first == null)
			first = last;
		else
			temp.next = last;
	}

	// while loop through linked list to find key, returns value
	public String find(int key) {
		if (first == null)
			return null;
		Node current = first;
		while (current != null) {
			if (current.key == key) {
				return current.data;
			}
			current = current.next;
		}
		return null;
	}

	// function to delete. while loop to find if found then previous.next and
	// curren.next are connected to break deleted node off
	public boolean delete(int key) {
		if (first == null)
			return false;
		if (first.key == key) {
			first = first.next;
			return true;
		}
		Node current = first;
		Node previous = null;
		while (current != null && current.key != key) {
			previous = current;
			current = current.next;
		}
		if (current == null)
			return false;
		if (current.key == key) {
			previous.next = current.next;
			return true;
		}
		return false;
	}

	// to string for testing
	public String toString() {
		Node current = first;
		String result = "ULL: ";
		while (current != null) {
			result += "(" + current.data + "," + current.key + ")-->";
			current = current.next;
		}
		return result;
	}
}
