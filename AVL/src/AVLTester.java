import java.util.Iterator;
import java.util.Random;

public abstract class AVLTester {
	public static void main(String[] args) {
		AVLTree AVL = new AVLTree();
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			String value = Integer.toString(rand.nextInt(100) + 1);
			String key = "A" + i;
			AVL.insert(key, value);
		}
		AVL.insert("c", "4");
		AVL.insert("r", "2");
		AVL.insert("s", "6");
		AVL.insert("f", "5");
		AVL.insert("a", "10");
		AVL.insert("d", "1");
		AVL.insert("o", "3");
		AVL.insert("n", "4");
		AVL.insert("i", "7");
		AVL.insert("j", "8");
		AVL.insert("k", "12");
		AVL.insert("l", "14");
//		AVL.insert("m", "100");
//		AVL.insert("h", "4");
//		AVL.insert("g", "7");
//		AVL.insert("p", "8");
//		AVL.insert("q", "12");
//		AVL.insert("b", "14");
//		AVL.insert("e", "100");
//		AVL.insert("x", "20");
//		AVL.insert("y", "20");
//		AVL.insert("z", "20");
//		AVL.insert("t", "20");
//		AVL.insert("u", "20");
//		AVL.insert("v", "20");





		//AVL.printTree();
		
		System.out.print(AVL.getBFSIterator());
		System.out.print(AVL.find("a"));
	}
	public static boolean verifyAVL(StringTree toTest){
		// TODO Return true if toTest is an AVL implementation of a String tree and false otherwise. 
		// All StringTree interface methods must behave correctly
		// You may assume that size() and isEmpty() return the correct values
		// Other than this, do not assume anything about the tree toTest, including its start size.
//		public void makeEmpty();
//		public int size(); will return the correct answer
//		public void insert(String key, String value);
//		public String find(String key);
//		public Iterator<String> getBFSIterator();
		
		
		return false;
	}
	
	// You may use as many static helper functions as you think are necessary
}
