package sorting;

import java.util.Comparator;

/**
 * Class full of static sorting methods. Used to sort Integers.
 * 
 * TODO: Implement mergeSort() and selectionSort().
 * 
 * insertionSort is implemented for you as an example.
 * 
 * @author pattersp
 *
 */

public class IntegerSorter {
	/**
	 * Sorts the given array of integers in ascending order according to the
	 * comparator using mergesort. You may create as many private helper
	 * functions as you wish to implement this method.
	 * 
	 * A note about ascending order:
	 * 
	 * When the method is finished, it should be true that:
	 * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
	 * array.length.
	 * 
	 * @param array
	 *            the integers to sort
	 * @param comparator
	 *            The comparator the will be used to compare two integers.
	 */
	public static void mergeSort(Integer[] array, Comparator<Integer> comparator) {
		if (array == null)
			throw new UnsupportedOperationException();
		mergeSort(array, 0, array.length - 1, comparator);
	}

	private static void mergeSort(Integer[] array, int left, int right, Comparator<Integer> comparator) {
		if (right > left) {
			int middle = (left + right) / 2;
			mergeSort(array, left, middle, comparator);
			mergeSort(array, middle + 1, right, comparator);
			merge(array, left, middle, right, comparator);
		}
	}

	private static void merge(Integer[] array, int left, int middle, int right, Comparator<Integer> comparator) {
		int length = right - left + 1;
		int mid = middle - left + 1;

		Integer[] temp = new Integer[length];

		for (int i = 0; i < length; ++i)
			temp[i] = array[left + i];

		int i = 0, j = mid, position = left;
		while (i < mid && j < length) {
			if (comparator.compare(temp[i], temp[j]) < 0)
				array[position] = temp[i++];
			else
				array[position] = temp[j++];

			position++;
		}
		while (i < mid)
			array[position++] = temp[i++];

		while (j < length - mid)
			array[position++] = temp[j++];
	}

	/**
	 * Sort the array of integers in ascending order according to the comparator
	 * using selection sort.
	 * 
	 * A note about ascending order:
	 * 
	 * When the method is finished, it should be true that:
	 * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
	 * array.length.
	 * 
	 * @param array
	 *            the array of integer that will be sorted.
	 * @param comparator
	 *            The comparator the will be used to compare two integers.
	 */
	public static void selectionSort(Integer[] array, Comparator<Integer> comparator) {
		if (array == null)
			throw new UnsupportedOperationException();
		for (int i = 0; i < array.length - 1; i++) {
			int position = i;
			for (int j = i + 1; j < array.length; j++) {
				if (comparator.compare(array[j], array[position]) < 0)
					position = j;
			}
			int smallestNum = array[position];
			array[position] = array[i];
			array[i] = smallestNum;
		}
	}

	/**
	 * Sort the array of integers in ascending order according to the comparator
	 * using insertion sort.
	 * 
	 * A note about ascending order:
	 * 
	 * When the method is finished, it should be true that:
	 * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
	 * array.length.
	 * 
	 * @param array
	 *            the array of integers that will be sorted.
	 * @param comparator
	 *            The comparator the will be used to compare two integer.
	 */
	public static void insertionSort(Integer[] array, Comparator<Integer> comparator) {
		for (int outerIndex = 1; outerIndex < array.length; outerIndex++) {
			Integer currentInt = array[outerIndex];
			int innerIndex = outerIndex - 1;
			while (innerIndex >= 0 && comparator.compare(currentInt, array[innerIndex]) < 0) {
				array[innerIndex + 1] = array[innerIndex];
				innerIndex--;
			}
			array[innerIndex + 1] = currentInt;
		}
	}
}
