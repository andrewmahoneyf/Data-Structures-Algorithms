import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	/*Your functions (on the left) correspond to the following java Queue functions (on the right)
	 * toTest.enqueue(String a) = toCompare.add(String a)
	 * toTest.dequeue() = toCompare.poll()
	 * toTest.front() = toCompare.peek()
	 * 
	 * This private class performs this interface for you.
	 */
    private static class JavaQueue{
    	//DO NOT EDIT THIS CLASS
    	Queue<String> queue;
    	protected JavaQueue(){
    		queue = new LinkedList<String>();
    	}
    	protected void enqueue(String a){
    		queue.add(a);
    	}
    	protected String dequeue(){
    		return queue.poll();
    	}
    	protected String front(){
    		return queue.peek();
    	}
    }

	public static void main(String[] args){

		boolean answer = testEmpty(new ListQueue(),new JavaQueue());
		boolean answer2 = testOne(new ListQueue(),new JavaQueue());
		boolean answer3 = testMany(new ListQueue(),new JavaQueue());
		
		System.out.println(answer);
		System.out.println(answer2);
		System.out.println(answer3);
	}
	
	public static boolean testEmpty(ListQueue yourQueue, JavaQueue correctQueue){
		//TODO implement a test of the three functions when the queues are empty
		//Compare the result of your queue  against the java implementation
		
		if ((yourQueue.dequeue() == correctQueue.dequeue()) && (yourQueue.front() == correctQueue.front())) {
			yourQueue.enqueue("blue");
			correctQueue.enqueue("blue");
			//System.out.println(yourQueue.asList());
			return yourQueue.front().equals(correctQueue.front());
		}
		return false;
	}
	
	public static boolean testOne(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have one element
		//Compare the result of your queue  against the java implementation
		a.enqueue("red");
		b.enqueue("red");
		if(a.front() == b.front()){
			a.enqueue("blue");
			b.enqueue("blue");
			a.dequeue();
			b.dequeue();
			return a.front().equals(b.front());
		}
		return false;
	}
	
	public static boolean testMany(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have many elements
		//Compare the result of your queue  against the java implementation
		//More than one test may be necessary
		String[] colors = {"red", "blue", "yellow", "green", "black", "white", "orange", "pink"};
		String[] sizes = {"small", "medium", "large"};
		
		for(int i = 0; i<colors.length-1; i++){
			a.enqueue(colors[i]);
			b.enqueue(colors[i]);
		}
		if(a.dequeue() == b.dequeue()){
			a.dequeue();
			b.dequeue();
			for(int i = 0; i< sizes.length-1; i++){
				a.enqueue(sizes[i]);
				b.enqueue(sizes[i]);
			}
			if(a.front() == b.front()){
				for(int j=0; j<5; j++){
					a.dequeue();
					b.dequeue();
				}
				System.out.println(a.dequeue() + " " + b.dequeue());
				System.out.println(a.front() + " " + b.front());
				for(int i = 0; i< sizes.length-1; i++){
					a.enqueue(sizes[i]);
					a.dequeue();
					b.enqueue(sizes[i]);
					b.dequeue();
				}
				return (a.front() == b.front());
			}
		}
		return false;
	}
}
