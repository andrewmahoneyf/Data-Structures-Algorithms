public class BSTDict implements Dictionary {
	private class BSTNode {
		private int key;
		private String value;
		private BSTNode left;
		private BSTNode right;

		BSTNode(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private BSTNode root;

	// insert methods takes in pair and calls add helper method creates a binary
	// tree through root
	public void insert(int key, String value) {
		root = add(key, value, root);
	}

	// helper method uses recursion to add bst node to the left child if key is
	// smaller or right if bigger
	public BSTNode add(int key, String value, BSTNode node) {
		if (node == null)
			return new BSTNode(key, value);
		if (key == node.key)
			node.value = value;
		else {
			if (key < node.key) {
				node.left = add(key, value, node.left);
			} else {
				node.right = add(key, value, node.right);
			}

		}
		return node;
	}

	// binary serach method to find key and return value
	public String find(int key) {
		BSTNode node = root;
		while (node != null) {
			if (key == node.key) {
				return node.value;
			}
			if (key < node.key) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}

	// delete method takes in key, calls find method to look for it and return
	// flase if not found. if found calls remove helper function
	public boolean delete(int key) {
		if (find(key) == null) {
			return false;
		}
		root = remove(key, root);
		return true;
	}

	// remove helper function uses recursion to replace node with childeren if
	// needed and make null if no children
	public BSTNode remove(int key, BSTNode node) {
		if (node == null)
			return null;
		if (key == node.key) {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				node = null;
			}
		} else {
			if (key < node.key) {
				node.left = remove(key, node.left);
			} else {
				node.right = remove(key, node.right);
			}
		}
		return node;
	}
}
