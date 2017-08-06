public class SLLDict implements Dictionary {
	private class Node {
		private String data;
		private int key;
		private Node next;

		Node(int i, String s) {
			key = i;
			data = s;
		}
	}

	private Node first;

	// inserts into sorted linked list. if key is smaller than next nodes keys
	// then connects previous to current and current to next
	public void insert(int key, String value) {
		Node newInsert = new Node(key, value);
		if (first == null)
			first = newInsert;
		else if (first.key > newInsert.key) {
			newInsert.next = first;
			first = newInsert;
		} else {
			Node current = first.next;
			Node previous = first;
			while (current != null) {
				if (current.key > newInsert.key) {
					break;
				}
				previous = current;
				current = current.next;
			}
			newInsert.next = current;
			previous.next = newInsert;
		}
	}

	// simple while loop through linked list to find key and return value
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

	// traverses through front to find node and if found disconnect it
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
		String result = "SLL: ";
		while (current != null) {
			result += "(" + current.data + "," + current.key + ")-->";
			current = current.next;
		}
		return result;
	}

}
