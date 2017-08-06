import java.util.Iterator;

public class AVLTree implements StringTree {

	private class AVLNode {
		// Do not change these variable names
		String key;
		String value;
		AVLNode left;
		AVLNode right;
		int height;

		// Place any additional fields you need here
		AVLNode(String key, String value) {
			this.key = key;
			this.value = value;
			height = 1;
		}
	}

	// Use this variable as your root
	AVLNode root;

	public void makeEmpty() {
		// TODO Remove all elements from the AVL tree.
		root = null;
	}

	public int size() {
		// TODO Return the number of elements currently in the tree.
		return size(root);
	}

	// Helper method to recursively solve for size of Avl tree
	// returning the size of left and right sides plus one for root
	private int size(AVLNode node) {
		if (node == null)
			return (0);
		else {
			return (size(node.left) + 1 + size(node.right));
		}
	}

	public void insert(String key, String value) {
		// TODO Insert the <key,value> pair into the AVLTree
		// Throw an IllegalArgumentException if the client attempts to insert a
		// duplicate key
		if ((find(root, key) == value)) {
			throw new IllegalArgumentException("Duplicate Key");
		}
		root = insert(key, value, root);
	}

	// helper method uses recursion to add AVL node to the left child if key is
	// smaller or right if bigger while maintaining AVL property through
	// rotations
	private AVLNode insert(String key, String value, AVLNode node) {
		if (node == null)
			return new AVLNode(key, value);
		if (key.compareTo(node.key) < 0) {
			node.left = insert(key, value, node.left);

		} else {
			node.right = insert(key, value, node.right);

		}

		if (height(node.left) - height(node.right) == 2) {
			if (key.compareTo(node.left.key) < 0)
				node = rotateLeft(node);
			else
				node = doubleLeft(node);
		}
		if (height(node.right) - height(node.left) == 2) {
			if (key.compareTo(node.right.key) > 0)
				node = rotateRight(node);
			else
				node = doubleRight(node);
		}
		return node;
	}

	// Helper rotate node with left child
	private AVLNode rotateLeft(AVLNode node) {
		AVLNode temp = node.left;
		node.left = temp.right;
		temp.right = node;
		return temp;
	}

	// Helper rotate node left with right and then node with new right child
	private AVLNode doubleLeft(AVLNode node) {
		node.left = rotateRight(node.left);
		return rotateLeft(node);
	}

	// Helper rotate node with right child
	private AVLNode rotateRight(AVLNode node) {
		AVLNode temp = node.right;
		node.right = temp.left;
		temp.left = node;
		return temp;
	}

	// Helper rotate node right with left and then node with new left child
	private AVLNode doubleRight(AVLNode node) {
		node.right = rotateLeft(node.right);
		return rotateRight(node);
	}

	// Method returns height of node
	private int height(AVLNode node) {
		if (node == null) {
			return 0;
		}
		node.height = count(node);
		return node.height;
	}

	// helper method for height returns the count of the longest side
	int count(AVLNode node) {
		AVLNode right = node.right;
		AVLNode left = node.left;
		int l = 0;
		int r = 0;
		if (right != null)
			r += count(right);
		if (left != null)
			l += count(left);
		return max(l, r) + 1;
	}

	// Helper method for count. returns max height of the two sides
	private int max(int l, int r) {
		int max = l;
		if (r > l) {
			max = r;
		}
		return max;
	}

	public String find(String key) {
		// TODO Return the value affiliated with the String key.
		// Throw an ObjectNotFoundException if the key is not in the AVLTree
		String value = find(root, key);
		if (value == null) {
			try {
				throw new ObjectNotFoundException();
			} catch (ObjectNotFoundException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	// Helper method for find to use recursion for search, returns the value
	// associated with key if found and null if not
	private String find(AVLNode node, String key) {
		while (node != null) {
			if (key == node.key) {
				return node.value;
			}
			if (key.compareTo(node.key) < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}

	// This function should return a BFSIterator:
	public Iterator<String> getBFSIterator() {
		if (size() == 0) {
			throw new IllegalArgumentException("Tree is empty");
		}

		return new BFSIterator(root);
	}

	private class BFSIterator implements Iterator<String> {
		private AVLNode tree;
		// private Iterator<String> queue;

		public BFSIterator(AVLNode root) {
			this.tree = root;
		}

		@Override
		public boolean hasNext() {
			return size(tree) > 0;
		}

		@Override
		public String next() {
			return next(tree);
		}

		private String next(AVLNode node) {

			return null;
		}
	}
}
