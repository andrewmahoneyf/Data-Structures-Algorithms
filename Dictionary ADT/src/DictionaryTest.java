import java.util.Random;
import java.lang.*;
public class DictionaryTest {

	public static void main(String[] args) {
		int inputSize = 1;
		int inputSize2 = 100000;
		
//		Dictionary ULLtest = initialInsert(new ULLDict(), inputSize);
//		Dictionary SLLtest = initialInsert(new SLLDict(), inputSize);
//		Dictionary UAtest = initialInsert(new UADict(), inputSize);
//		Dictionary SAtest = initialInsert(new SADict(), inputSize);
		Dictionary BSTtest = initialInsert(new BSTDict(), inputSize);
		Dictionary BSTtest2 = initialInsert(new BSTDict(), inputSize2);
//
//		long answer1 = testInsert(new ULLDict(), inputSize);
//		long answer2 = testInsert(new SLLDict(), inputSize);
//		long answer3 = testInsert(new UADict(), inputSize);
//		long answer4 = testInsert(new SADict(), inputSize);
		long answer1 = testInsert(new BSTDict(), inputSize);
		long answer2 = testInsert(new BSTDict(), inputSize2);

//		long answer6 = testFind(ULLtest);
//		long answer7 = testFind(SLLtest);
//		long answer8 = testFind(UAtest);
//		long answer9 = testFind(SAtest);
		long answer3 = testFind(BSTtest);
		long answer4 = testFind(BSTtest2);

//		long answer11 = testDelete(ULLtest, inputSize);
//		long answer12 = testDelete(SLLtest, inputSize);
//		long answer13 = testDelete(UAtest, inputSize);
//		long answer14 = testDelete(SAtest, inputSize);
		long answer5 = testDelete(BSTtest, inputSize);
		long answer6 = testDelete(BSTtest2, inputSize2);

		
		System.out.println("Nano Time");

		System.out.println("input size = \t1 \t\t100000\n");
	System.out.println("Insert Test:\t" +answer1 + "\t\t" + answer2);
	System.out
			.println("find Test:\t" + answer3 + "\t\t" + answer4);
		System.out.println(
				"Delete Test:\t" + answer5 + "\t\t" + answer6);
}
	public static Dictionary initialInsert(Dictionary toTest, int amount) {
		Random rand = new Random();
		for (int i = 0; i < amount; i++) {
			int key = rand.nextInt(100) + 1;
			String value = "andrew";
			toTest.insert(key, value);
		}
		return toTest;
	}

	public static long testInsert(Dictionary toTest, int amount) {
		long startTime = System.nanoTime();
		Random rand = new Random();
		for (int i = 0; i < amount; i++) {
			int key = rand.nextInt(10000) + 1;
			String value = "andrew";
			toTest.insert(key, value);
		}
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);

		return duration;
	}

	public static long testFind(Dictionary toTest) {
		long startTime = System.nanoTime();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int num = rand.nextInt(99) + 1;
			toTest.find(num);
		}
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);

		return duration;
	}

	public static long testDelete(Dictionary toTest,int amount) {
		long startTime = System.nanoTime();
		Random rand = new Random();
		for (int i = 0; i < amount; i++) {
			int num = rand.nextInt(amount) + 1;
			toTest.delete(num);
		}
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		return duration;
	}
}
