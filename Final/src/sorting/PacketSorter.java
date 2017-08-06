package sorting;

import java.util.Comparator;

/**
 * Class full of static sorting methods. Used to sort packets received from a
 * server containing image metadata.
 * 
 * TODO: Implement mergeSort() and selectionSort().
 * 
 * insertionSort is implemented for you as an example.
 * 
 * @author pattersp
 *
 */

public class PacketSorter {
    /**
     * Sorts the given array of packets in ascending order according to the
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
     *            the packets to sort
     * @param comparator
     *            The comparator the will be used to compare two packets.
     */
    public static void mergeSort(Packet[] array, Comparator<Packet> comparator) {
		if (array == null)
			throw new UnsupportedOperationException();
		mergeSort(array, 0, array.length - 1, comparator);
	}

	private static void mergeSort(Packet[] array, int left, int right, Comparator<Packet> comparator) {
		if (right > left) {
			int middle = (left + right) / 2;
			mergeSort(array, left, middle, comparator);
			mergeSort(array, middle + 1, right, comparator);
			merge(array, left, middle, right, comparator);
		}
	}

	private static void merge(Packet[] array, int left, int middle, int right, Comparator<Packet> comparator) {
		int length = right - left + 1;
		int mid = middle - left + 1;

		Packet[] temp = new Packet[length];

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
     * Sort the array of packets in ascending order using selection sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of packets that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two packets.
     */
    public static void selectionSort(Packet[] array, Comparator<Packet> comparator) {
    	if (array == null)
			throw new UnsupportedOperationException();
		for (int i = 0; i < array.length - 1; i++) {
			int position = i;
			for (int j = i + 1; j < array.length; j++) {
				if (comparator.compare(array[j], array[position]) < 0)
					position = j;
			}
			Packet smallestNum = array[position];
			array[position] = array[i];
			array[i] = smallestNum;
		}
    }

    /**
     * Sort the array of packets in ascending order using insertion sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of packets that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two packets.
     */
    public static void insertionSort(Packet[] array,
            Comparator<Packet> comparator) {
        for (int outerIndex = 1; outerIndex < array.length; outerIndex++) {
            Packet currentPacket = array[outerIndex];
            int innerIndex = outerIndex - 1;
            while (innerIndex >= 0
                    && comparator.compare(currentPacket, array[innerIndex]) < 0) {
                array[innerIndex + 1] = array[innerIndex];
                innerIndex--;
            }
            array[innerIndex + 1] = currentPacket;
        }
    }
}
