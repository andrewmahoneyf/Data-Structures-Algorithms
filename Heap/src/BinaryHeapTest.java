//import QueueTest.JavaQueue;

public abstract class BinaryHeapTest {

	public static void main(String[] args) {
		// Use your tests here to make sure your implementation is working, this is for your help
		// Call your tests here to make sure that your implementation works.
		// This section will not be graded
		boolean answer = testEmpty(new BinaryHeap());
		boolean answer2 = testOne(new BinaryHeap());
		boolean answer3 = testMany(new BinaryHeap());
		
		System.out.println(answer);
		System.out.println(answer2);
		System.out.println(answer3);

	}
	
	//Make the below tests as thorough as possible.
	//Assume toTest is empty when the function is called
	//These will be tested against other implementations, both correct and incorrect, so be as thorough as you can
	//Only applicable functions need to be tested at each level.
	//Helper tests are strongly recommended
	
	public static boolean testEmpty(BinaryHeap toTest){
		//TODO write a test case that tests functionality for all of the functions applicable to a BinaryHeap when it is empty
		//toTest should be empty when it is called
		//You may find writing helper tests to be useful
		//This should return true if it passes your tests, false otherwise
		
		if(toTest.size() == 0 && toTest.isEmpty()){
			if(toTest.deleteMin() == null && toTest.findMin() == null){
				toTest.insert("blue", 1);
				if(toTest.findMin() == "blue"){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean testOne(BinaryHeap toTest){
		//TODO write a test case that tests functionality for all of the functions applicable to a BinaryHeap when it has one element
		//Add the element in this function, toTest should be empty when it is called.
		//You may find writing helper tests to be useful
		//This should return true if it passes your tests, false otherwise
		toTest.insert("blue", 2);
		if(toTest.size() == 1 && !toTest.isEmpty()){
			toTest.insert("red", 1);
			if(toTest.findMin() == "blue"){
				toTest.changePriority("red", 3);
				if(toTest.deleteMin() == "red"){
					return true;
				}
			}
		}
		return false;
	}
	
	private static char[] deleteMin() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean testMany(BinaryHeap toTest){
		//TODO write a test case that tests functionality for all of the functions applicable to a BinaryHeap when it has many elements
		//Add the elements to the BinaryHeap in this function, toTest should be empty when it is called.
		//You may find writing helper tests to be useful
		//This should return true if it passes your tests, false otherwise
		toTest.insert("blue", 2);
		toTest.insert("green", 4);
		toTest.insert("red", 1);
		toTest.insert("white", 5);
		if(toTest.size() == 4 && !toTest.isEmpty()){
			toTest.insert("black", 3);
			if(toTest.deleteMin() == "white"){
				toTest.changePriority("red", 5);		
				if(toTest.findMin() == "red"){
					toTest.makeEmpty();
					return toTest.isEmpty();
				}
			}
		}
		return false;
	}

}
