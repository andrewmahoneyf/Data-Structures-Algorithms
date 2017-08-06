public class SADict implements Dictionary {
	private class ArrayData {
		int key;
		private String value;

		ArrayData(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private ArrayData[] array;
	private int size;

	// construct empty array with capacity of 5
	public SADict() {
		array = new ArrayData[5];
		size = 0;
	}

	// get size of filled section
	public int size() {
		return size;
	}

	// double array capacity i fsize of array gets close to full
	public void resize(int capacity) {
		capacity = size * 2;
		ArrayData[] temp = new ArrayData[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}

	// inserts in sorted order. Traverses array from front to detect if there
	// are any keys bigger than the key, value pair getting inserted. if so will
	// insert then move rest of array over one by one
	public void insert(int key, String value) {
		if (size == array.length)
			resize(size);
		ArrayData insert = new ArrayData(key, value);
		if (size == 0)
			array[size++] = insert;
		else {
			int i;
			for (i = 0; i < size; i++) {
				if (key < array[i].key)
					break;
			}
			for (int j = size - 1; j >= i; j--) {
				array[j + 1] = array[j];
			}
			array[i] = insert;
			size++;
		}
	}

	// binary search to find key then returns its value
	public String find(int key) {
		int low = 0;
		int high = size;
		while (high >= low) {
			int middle = (low + high) / 2;
			if (array[middle].key == key) {
				return array[middle].value;
			}
			if (array[middle].key < key) {
				low = middle + 1;
			}
			if (array[middle].key > key) {
				high = middle - 1;
			}
		}
		return null;
	}

	// binary search to find key, once found moves right elements over to the
	// left one by one
	public boolean delete(int key) {
		int low = 0;
		int high = size;
		while (high > low) {
			int middle = (low + high) / 2;
			if (array[middle].key == key) {
				for (int i = middle; i < size; i++) {
					array[i] = array[i + 1];
				}
				size--;
				return true;
			}
			if (array[middle].key < key) {
				low = middle + 1;
			}
			if (array[middle].key > key) {
				high = middle - 1;
			}
		}
		return false;
	}

	// to string method for testing
	public String toString() {
		String result = "SA: ";
		for (int i = 0; i < size; i++) {
			result += "(" + array[i].value + "," + array[i].key + "), ";
		}
		return result;
	}

}
