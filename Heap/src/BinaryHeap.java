
public class BinaryHeap implements PriorityQueue{
	private class HeapData{
		private String data;
		private int priority;
		
		protected HeapData(String dat,int pri){
			data = dat;
			priority = pri;
		}
		
		protected void changePriority(int newPri){
			priority = newPri;
		}
		// Add additional functions here as necessary
	}
	
	private HeapData[] heap; 

	private int size, startArray;
	
	// Constructor to instantializes an empty Heap
	public BinaryHeap(){
		size = 0;
		heap = new HeapData[2];
	}
	
	// Constructor instantializes an empty Heap where the array is of size startArray.
	public BinaryHeap(int startArray){
		this.startArray = startArray + 1;
		heap = new HeapData[this.startArray];
		size = 0;
	}
	
	// This function returns true if the heap is empty (size = 0) and false otherwise.
	public boolean isEmpty(){
		return size == 0;
	}
	
	// This function returns the current number of items in the heap.
	public int size(){
		return size;
	}
	
	// This function returns the item of smallest priority in the heap without 
	// removing it. If the heap is empty, it returns null.
	public String findMin(){
		if (this.isEmpty()){
			return null;
		}
		HeapData min = heap[1]; 
		for(int i = 2; i <= size; i++){
			if (min.priority < heap[i].priority){
				min = heap[i];
			}
		}
		return min.data;
	}
	
	// This function adds the String, priority pair into the heap sorting by priority.
	public void insert(String data, int priority){
		HeapData newPoint = new HeapData(data, priority);
		if (size == heap.length - 1){
			HeapData[] newHeap = new HeapData[size + 2];
			for (int i = 1; i <= heap.length -1; i++){
				newHeap[i] = heap[i];
			}
			heap = newHeap;
		}
		size++;
		int position = size;
		if (size < 3 || newPoint.priority > heap[position/2].priority){
			heap[position] = newPoint;
		} else {
			while (position != 1 && newPoint.priority < heap[position/2].priority){
				heap[position] = heap[position/2];
				position /= 2;
			}
			heap[position] = newPoint;
		}
	}
	
	// This function returns and removes the item of smallest priority in the heap. 
	// Objects of duplicate priority may dequeue in any order. If the heap is empty, it should return null.
	public String deleteMin(){
		if (this.isEmpty()){
			return null;
		}	
		HeapData min = heap[size]; 
		int index = size;
		for(int i = 1; i <= size; i++){
			if (min.priority < heap[i].priority){
				min = heap[i];
				index = i;
			}
		} 
		String temp = min.data;
		int child = 2 * index; // left child, if any
	    while (child < size){
	    	if (child + 1 < size){ // right child also
	    		if (heap[child].priority > heap[child + 1].priority){
	    			child = child + 1;
	    		}
	    	}
	    	heap[index] = heap[child];
	    	heap[child] = min;
	    	index = child;
	    	child = 2 * index;
	    }
	    while(index < size){
	    	heap[index] = heap[index+1];
	    	index ++;
	    }
		heap[index].data = "";
	    size --;
		return temp;
	}
	
	// This function removes all elements from the heap
	public void makeEmpty(){
		heap = new HeapData[startArray];
		size = 0;
	}
	
	// This function changes the priority of a String in the heap.This function returns
	// true if successful, and false if it is unable to find the String in the heap.
	public boolean changePriority(String data, int newPri){
		int lowestPri = heap[1].priority;
		for (int j = 2; j <= size; j ++){
			if (heap[j].priority > lowestPri){
				lowestPri = heap[j].priority;
			}
		}
		for(int i = 1; i <= heap.length - 1; i++){
			if(heap[i].data == data){
				heap[i].priority = lowestPri + 1;
				deleteMin();
				insert(data, newPri);
				return true;
			}
		}
		return false;
	}

}
