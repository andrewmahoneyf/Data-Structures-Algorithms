public class UADict implements Dictionary {
	private class ArrayData {
		private int key;
		private String value;

		ArrayData(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private ArrayData[] array;
	private int size;

	// construct empty array length of 5, size 0
	public UADict() {
		array = new ArrayData[5];
		size = 0;
	}

	// return size of filled section of array
	public int size() {
		return size;
	}

	// resizes the array taking in the current size and making a new array with
	// double capacity
	public void resize(int capacity) {
		capacity = size * 2;
		ArrayData[] temp = new ArrayData[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}

	// insert pair at end of size which is length of filled section
	public void insert(int key, String value) {
		if (size == array.length)
			resize(size);
		array[size++] = new ArrayData(key, value);
	}

	// takes in a key and traverses array to find that value returning the
	// string if found or null if not
	public String find(int key) {
		for (int i = 0; i < size; i++) {
			if (array[i].key == key) {
				return array[i].value;
			}
		}
		return null;
	}

	// finds pair to be deleted and replaces it with the pair at the end of the
	// array then reduces size so that pair isnt accounted for anymore
	public boolean delete(int key) {
		for (int i = 1; i < size; i++) {
			if (array[i].key == key) {
				array[i] = array[--size];
				return true;
			}
		}
		return false;
	}

	// to string method for testing
	public String toString() {
		String result = "UA: ";
		for (int i = 0; i < size; i++) {
			result += "(" + array[i].value + "," + array[i].key + "), ";
		}
		return result;
	}

}
